package ru.web.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    

    @Test
    public void testContactDeletion() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletionSelectedContact();
        app.getContactHelper().returntoContactPage();
    }

}
