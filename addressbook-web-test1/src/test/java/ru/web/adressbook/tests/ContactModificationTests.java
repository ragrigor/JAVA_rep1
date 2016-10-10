package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData("eeeTest2", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666", "5", "February", "2012"));
        }
    }
    
       @Test
    public void testContactModification() {

           List<ContactData> before = app.contact().list();
           int index  = before.size() - 1;
           ContactData contact = new ContactData(before.get(index).getId(), "Test5a", null, null, "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666", "5", "February", "2012");
           app.contact().modify(index, contact);
           app.contact().returntoContactPage();
           List<ContactData> after = app.contact().list();
           Assert.assertEquals(after.size(), before.size());


           before.remove(index);
           before.add(contact);
           Comparator<? super ContactData> byId =  (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
           before.sort(byId);
           after.sort(byId);
           Assert.assertEquals(before, after);

    }




}
