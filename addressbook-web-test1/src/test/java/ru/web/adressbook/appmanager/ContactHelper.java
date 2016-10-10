package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.web.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);

    }
    public void initContactCreation(){
        click(By.linkText("add new"));

    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getMail1());
        type(By.name("email2"), contactData.getMail2());
        type(By.name("home"), contactData.getPhone1());
        type(By.name("mobile"), contactData.getPhone2());
        type(By.name("work"), contactData.getPhone3());

        Select bDay = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[3]")));
        bDay.selectByVisibleText(contactData.getbDay());

        Select bMonth = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[4]")));
        bMonth.selectByVisibleText(contactData.getbMonth());

        type(By.name("ayear"), contactData.getbYear());

       // Select selectBDay1 = new Select(By.xpath("//div[@id='content']/form/select[3]//option[" + index + "]")
        //type(By.xpath("//div[@id='content']/form/select[3]//option[3]"), null);

       /* public void selectBDay (int index) {
            //click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
            Select(By.xpath("//div[@id='content']/form/select[3]//option[" + index + "]");
            //wd.findElements(By.name("entry")).get(index).findElements(By.tagName("td")).get(index).findElement(By.tagName("a")).click();
        }  */

    }


    public void submitContactCreation(){
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returntoContactPage() {
        click(By.linkText("home"));

    }

    public void selectContact(int index) {
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
    }

    public void deleteSelectedContact(){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletionSelectedContact(){
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        index ++;
        //click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
        click(By.xpath("//tr[@name='entry'][" + index + "]//td[8]/a"));
        //wd.findElements(By.name("entry")).get(index).findElements(By.tagName("td")).get(index).findElement(By.tagName("a")).click();
    }

    public void submitContactModification(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));

    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returntoContactPage();
    }

    public void modify(int index, ContactData contact) {
        selectContact(index);
        initContactModification(index);
        fillContactForm(contact);
        submitContactModification();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        acceptDeletionSelectedContact();
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String name1 = cells.get(2).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstName(name1);
            contacts.add(contact);
        }
        return contacts;
    }
}