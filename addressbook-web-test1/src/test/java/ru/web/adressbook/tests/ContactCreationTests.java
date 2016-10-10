package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData().withFirstName("Test8").withAddress("2 TestStreet ").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

     /*   int max = 0;
        for (ContactData c : after){
            if(c.getId() > max) {
                max = c.getId();
            }
        }  */

        //contact.withId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId =  (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }




}
