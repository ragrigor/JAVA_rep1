package ru.web.mantis.tests;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.web.mantis.model.MailMessage;
import ru.web.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

/**
 * Created by Радочка on 06.11.2016.
 */
public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        app.login().asAdmin();
        List<Users> users = app.db().users().stream().filter((u) -> !u.getUsername().equals("administrator"))
                .collect(Collectors.toList());
        Users user = users.iterator().next();
        String name = user.getUsername();
        String email = user.getEmail();
        String password = "password";

        app.resetPassword().start(user);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        // user = wd.findElement(By.cssSelector("input[id='edit-username']")).getAttribute("value");
        String confirmationLink = findConfirmationLink(mailMessages);
        app.resetPassword().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user.getUsername(), password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages) {
      MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.contains("@localhost")).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }



    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }

}

