package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    
       @Test
    public void testContactModification() {

           app.getNavigationHelper().gotoContactPage();
           app.getContactHelper().selectContact();
           app.getContactHelper().initContactModification();
           app.getContactHelper().fillContactForm(new ContactData("WTest2", "eeeTest2", "2 TestStreet ", "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666"));
           app.getContactHelper().submitContactModification();
           app.getContactHelper().returntoContactPage();

    }
    

}
