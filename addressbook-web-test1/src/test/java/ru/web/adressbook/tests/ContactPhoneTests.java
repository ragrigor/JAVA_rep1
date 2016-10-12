package ru.web.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Радочка on 12.10.2016.
 */
public class ContactPhoneTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet ").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withBDay("6").withBMonth("February").withBYear("2012"));
        }
    }

    @Test
    public void testContactPhone() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getPhone1(), equalTo(cleaned(contactInfoFromEditForm.getPhone1())));
        assertThat(contact.getPhone2(), equalTo(cleaned(contactInfoFromEditForm.getPhone2())));
        assertThat(contact.getPhone3(), equalTo(cleaned(contactInfoFromEditForm.getPhone3())));

    }

    public String cleaned(String phone){
        return phone.replaceAll("[-()]", "");
    }
}