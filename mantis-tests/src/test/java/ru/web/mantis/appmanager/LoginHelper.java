package ru.web.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Радочка on 06.11.2016.
 */
public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager app) {
        super(app);
    }

    public void asAdmin() {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), (String) app.getProperty("web.adminLogin"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[type='submit']"));
    }
}