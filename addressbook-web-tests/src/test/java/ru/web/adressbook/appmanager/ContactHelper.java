package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.adressbook.model.ContactData;

/**
 * Created by Радочка on 24.09.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
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
        click(By.linkText("home"));

    }

    public void selectContact() {
        click(By.xpath("//input[@name='selected[]']"));
    }
    public void deleteSelectedContact(){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletionSelectedContact(){
        wd.switchTo().alert().accept();
    }

    public void initContactModification(){
        click(By.xpath("//table[@id='maintable']/tbody/tr[5]/td[8]/a/img"));
    }

    public void submitContactModification(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));

    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returntoContactPage();
    }
}