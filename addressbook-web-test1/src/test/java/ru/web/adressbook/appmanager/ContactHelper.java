package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);

    }

    public void initContactCreation() {
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
        bDay.selectByVisibleText(contactData.getaDay());

        Select bMonth = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[4]")));
        bMonth.selectByVisibleText(contactData.getaMonth());

        type(By.name("ayear"), contactData.getaYear());
        attach(By.name("photo"), contactData.getPhoto());

        // Select selectBDay1 = new Select(By.xpath("//div[@id='content']/form/select[3]//option[" + index + "]")
        //type(By.xpath("//div[@id='content']/form/select[3]//option[3]"), null);

       /* public void selectBDay (int index) {
            //click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
            Select(By.xpath("//div[@id='content']/form/select[3]//option[" + index + "]");
            //wd.findElements(By.name("entry")).get(index).findElements(By.tagName("td")).get(index).findElement(By.tagName("a")).click();
        }  */

    }


    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returntoContactPage() {
        click(By.linkText("home"));

    }

    public void selectContact(int index) {
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletionSelectedContact() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int id) {
        //   index ++;
        //click(By.xpath("//*[@id='maintable']/tbody/tr[" + index + "]/td[8]/a/img"));
        //click(By.xpath("//tr[@name='entry'][" + index + "]//td[8]/a"));
        // click(By.xpath("./../..//td[8]/a"));
        //WebElement row = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        row.findElement(By.xpath("./td[8]/a")).click();
       // wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();


        //wd.findElements(By.name("entry")).get(index).findElements(By.tagName("td")).get(index).findElement(By.tagName("a")).click();
    }

    public void viewProfileDetails(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        row.findElement(By.xpath("./td[7]/a")).click();
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    //  public boolean isThereAContact() {
    //     return isElementPresent(By.xpath("//input[@name='selected[]']"));

    // }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        contactCache = null;
        returntoContactPage();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
    }

    /*  public void delete(int index) {
          selectContact(index);
          deleteSelectedContact();
          acceptDeletionSelectedContact();

      }  */
    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        acceptDeletionSelectedContact();
        contactCache = null;
    }


    public int getContactCount() {
        return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

   /* public List<ContactData> list() {
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
    }  */

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String allMails = cells.get(4).getText();
            String address = cells.get(3).getText();
            // String[] phones = cells.get(5).getText().split("\n");

            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
           // ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withPhone1(phones[0]).withPhone2(phones[1]).withPhone3(phones[2]);
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
                    .withAddress(address).withAllMails(allMails).withAllPhones(allPhones);
            contactCache.add(contact);
        }
        return contactCache;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String  aDay = wd.findElement(By.name("aday")).getAttribute("value");
        String  aMonth = wd.findElement(By.name("amonth")).getAttribute("value");
        String  aYear = wd.findElement(By.name("ayear")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstName)
                .withLastName(lastName).withAddress(address).withMail1(email).withMail2(email2).withMail3(email3)
                .withPhone1(homePhone).withPhone2(mobilePhone).withPhone3(workPhone).withADay(aDay).withAMonth(aMonth).withAYear(aYear);
    }

    public ContactData infoFromProfileFrom(ContactData contact) {
        viewProfileDetails(contact.getId());
        String allDetails = wd.findElement(By.id("content")).getText();
        wd.navigate().back();
        return new ContactData().withAllDetails(allDetails);
    }
}
