package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{

    
       @Test
    public void testContactModification() {

           app.getNavigationHelper().gotoContactPage();
           if (! app.getContactHelper().isThereAContact()){
               app.getContactHelper().createContact(new ContactData("eeeTest2", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666"));
           }
           List<ContactData> before = app.getContactHelper().getContactList();
           app.getContactHelper().selectContact(before.size() - 1);
           app.getContactHelper().initContactModification();
           app.getContactHelper().fillContactForm(new ContactData("WTest2", null, null, "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666"));
           app.getContactHelper().submitContactModification();
           app.getContactHelper().returntoContactPage();
           List<ContactData> after = app.getContactHelper().getContactList();
           Assert.assertEquals(after.size(), before.size());

    }
    

}
