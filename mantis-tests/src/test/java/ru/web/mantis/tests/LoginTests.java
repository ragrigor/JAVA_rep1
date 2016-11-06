package ru.web.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Радочка on 05.11.2016.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isLoggedInAs("administrator"));
        System.out.println((String) app.getProperty("web.adminLogin"));
    }
}
