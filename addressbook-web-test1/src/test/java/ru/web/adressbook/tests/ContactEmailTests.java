package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.web.adressbook.tests.TestBase.app;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet ")
                    .withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666")
                    .withBDay("6").withBMonth("February").withBYear("2012"));
        }
    }

    @Test
    public void testContactEmail() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


        assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));

    }

    private String mergeMails(ContactData contact) {
        return Arrays.asList(contact.getMail1(), contact.getMail2(), contact.getMail3())
                .stream().filter((s)  -> s != null && !s.equals("")).map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("[-()]", "");
    }
}
