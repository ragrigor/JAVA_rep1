package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
    

    @Test
    public void testContactDeletion() {

        app.getNavigationHelper().gotoContactPage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("eeeTest2", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletionSelectedContact();
        app.getContactHelper().returntoContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }

}
