package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Радочка on 22.09.2016.
 */
public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);

    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoContactPage(){
        click(By.linkText("home"));
    }
}
