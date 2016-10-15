package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactProfileTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstName("eeeTest2").withAddress("2 TestStreet ").withMail1("test22@gmail.com").withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withADay("6").withAMonth("February").withAYear("2012"));
        }
    }

    @Test
    public void testContactProfile() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoFromProfileForm = app.contact().infoFromProfileFrom(contact);


        assertThat(mergeProfileDetails(contactInfoFromProfileForm), equalTo(mergeEditDetails(contactInfoFromEditForm)));

       /* assertThat(contact.getPhone1(), equalTo(cleaned(contactInfoFromEditForm.getPhone1())));
        assertThat(contact.getPhone2(), equalTo(cleaned(contactInfoFromEditForm.getPhone2())));
        assertThat(contact.getPhone3(), equalTo(cleaned(contactInfoFromEditForm.getPhone3())));   */

    }

    private String mergeEditDetails(ContactData contact) {
        return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getAddress(),
                contact.getPhone1(), contact.getPhone2(), contact.getPhone3(),
                contact.getMail1(), contact.getMail2(), contact.getMail3(),
                contact.getaDay(), contact.getaMonth(), contact.getaYear())
                .stream().filter((s)  -> s != null && ! s.equals("")).map(ContactProfileTests::cleaned)
                .collect(Collectors.joining(""));
    }
    private String mergeProfileDetails(ContactData contact){
        return Arrays.asList(contact.getAllDetails())
                .stream().filter((s) -> s != null && ! s.equals("")).map(ContactProfileTests::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned(String profile){
        return profile.replace("H:", "").replace("M:", "").replace("W:", "")
                .replace(". ", "").replace("Anniversary ", "").replaceAll("\\([^()]*\\)", "").replace("\n", "").replace(" ", "");
    }
}

