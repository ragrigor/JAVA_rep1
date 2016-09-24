package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.web.adressbook.model.ContactData;

/**
 * Created by Радочка on 24.09.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);

    }
    public void initContactCreation(){
        click(By.linkText("add new"));

    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName1());
        type(By.name("lastname"), contactData.getName2());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getMail1());
        type(By.name("email2"), contactData.getMail2());
        type(By.name("home"), contactData.getPhone1());
        type(By.name("mobile"), contactData.getPhone2());
        type(By.name("work"), contactData.getPhone3());
    }

    public void submitContactCreation(){
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returntoContactPage() {
        click(By.linkText("home page"));

    }
}