package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.web.adressbook.model.ContactData;

import static org.openqa.selenium.OutputType.*;

public class ContactModificationTests extends TestBase{

    
       @Test
    public void testContactModification() {

           app.getNavigationHelper().gotoContactPage();
           app.getContactHelper().selectContact();
           app.getContactHelper().initContactModification();
           app.getContactHelper().fillContactForm(new ContactData("WTest2", "eeeTest2", "2 TestStreet ", "test22@gmail.com", "test33@gmail.com", "456-444", "456-555", "456-666"));
           app.getContactHelper().submitContactModification();
           app.getContactHelper().returntoContactPage();

    }
    

}
