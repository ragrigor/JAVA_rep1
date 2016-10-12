package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012"));
        }
    }
    
       @Test
    public void testContactModification() {

           Contacts before = app.contact().all();
           ContactData modifiedContact = before.iterator().next();
           ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Test3").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012");
           app.contact().modify(contact);
           app.contact().returntoContactPage();
           Contacts after = app.contact().all();
           assertThat(after.size(),equalTo(before.size()));


           before.remove(modifiedContact);
          // before.add(contact);
          // assertEquals(before, after);
           assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }




}
