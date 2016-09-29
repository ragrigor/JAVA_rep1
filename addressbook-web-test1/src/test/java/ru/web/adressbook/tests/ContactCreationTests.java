package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("eeeTest2", null, "2 TestStreet ", "test22@gmail.com", null, "456-444", "456-555", "456-666"));

    }



}
