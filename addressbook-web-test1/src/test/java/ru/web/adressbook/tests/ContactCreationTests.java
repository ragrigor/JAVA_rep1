package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/sample.png");
        ContactData contact = new ContactData().withFirstName("Test1").withAddress("2 TestStreet ")
                .withMail1("test22@gmail.com")
                .withPhone1("456-444").withPhone2("456-555").withPhone3("456-666")
                .withADay("6").withAMonth("February").withAYear("2012")
                .withPhoto(photo);
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);

     /*   int max = 0;
        for (ContactData c : after){
            if(c.getId() > max) {
                max = c.getId();
            }
        }  */

        //contact.withId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
      //  contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
     //   before.add(contact);
     //   Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }




}
