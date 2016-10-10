package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;


import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet ").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012"));
        }
    }

    @Test
    public void testContactDeletion() {

        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.contact().returntoContactPage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);

    }



}
