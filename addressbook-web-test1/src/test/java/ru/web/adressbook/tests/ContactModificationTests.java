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
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012"));
        }
    }
    
       @Test
    public void testContactModification() {

           List<ContactData> before = app.contact().list();
           int index  = before.size() - 1;
           ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Test5a").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012");
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
