package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    
       @Test
    public void testContactModification() {

           app.getNavigationHelper().gotoContactPage();
           if (! app.getContactHelper().isThereAContact()){
               app.getContactHelper().createContact(new ContactData("eeeTest2", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666", "5", "February", "2012"));
           }
           List<ContactData> before = app.getContactHelper().getContactList();
           app.getContactHelper().selectContact(before.size() - 1);
           app.getContactHelper().initContactModification(before.size() - 1);
           ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Test5a", null, null, "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666", "5", "February", "2012");
           app.getContactHelper().fillContactForm(contact);
           app.getContactHelper().submitContactModification();
           app.getContactHelper().returntoContactPage();
           List<ContactData> after = app.getContactHelper().getContactList();
           Assert.assertEquals(after.size(), before.size());


           before.remove(before.size() - 1);
           before.add(contact);
           Comparator<? super ContactData> byId =  (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
           before.sort(byId);
           after.sort(byId);
           Assert.assertEquals(before, after);

    }
    

}
