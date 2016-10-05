package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Test1", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);

    }



}
