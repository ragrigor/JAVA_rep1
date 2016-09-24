package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Test2", "Test2", "2 TestStreet ", "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returntoContactPage();
    }



}
