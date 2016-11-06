package ru.web.mantis.appmanager;

import org.openqa.selenium.By;
import ru.web.mantis.model.Users;

/**
 * Created by Радочка on 06.11.2016.
 */
public class NavigationHelper extends HelperBase {
    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void chooseUser(Users user) {
        click(By.linkText(user.getUsername()));
    }
}
