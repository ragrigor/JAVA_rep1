package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Радочка on 13.10.2016.
 */
public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet ")
                    .withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666"));
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


        assertThat(cleaned(contact.getAddress()), equalTo(mergeAddress(contactInfoFromEditForm)));

    }

     private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s)  -> s != null && !s.equals("")).map(ContactAddressTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

     public static String cleaned(String address){
         return address.replaceAll(" ", "");
     }
    //    return phone.replaceAll("[-()]", "");
    //}
}
