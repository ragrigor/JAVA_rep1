package ru.web.adressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.Contacts;
import ru.web.adressbook.model.GroupData;
import ru.web.adressbook.model.Groups;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static sun.security.krb5.Confounder.intValue;

/**
 * Created by Радочка on 30.10.2016.
 */
public class ContactDeleteFromGroupTests extends TestBase {



    @BeforeMethod
    public void ensurePreconditions() {
        // if contact exists
        File photo = new File("src/test/resources/sample.png");
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstName("M_test").withLastName("test").withAddress("2 TestStreet")
                    .withMail1("test22@gmail.com").withMail2("test22@gmail.com").withMail3("test22@gmail.com")
                    .withPhone1("456-444").withPhone2("456-555").withPhone3("456-666").withPhoto(photo));
        }

        // if group exists
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName1("group3").withHeader("test").withFooter("test"));
        }
        // list of contacts empty
    }

        @Test
        public void testContactDeleteFromGroup(){

            Contacts before = app.db().contacts();
            ContactData contact = before.iterator().next();

            if (contact.getGroups().size() == 0){
                Groups allGroups = app.db().groups();
                GroupData groupToAdd = allGroups.iterator().next();
                app.goTo().contactPage();
                app.contact().addGroup(contact, groupToAdd);
            }
            app.goTo().contactPage();
            app.contact().sortByGroupAll();

            GroupData deletedGroup = contact.getGroups().iterator().next();
            //app.goTo().contactPage();
            app.contact().removeGroup(contact, deletedGroup);

            //Groups allGroups = app.db().groups();

        /*   if (contact.getGroups().size() != 0) {
                GroupData deletedGroup = contact.getGroups().iterator().next();
                app.goTo().contactPage();
                app.contact().removeGroup(contact, deletedGroup);
           } else {
                Groups allGroups = app.db().groups();
                GroupData groupToAdd = allGroups.iterator().next();
                app.goTo().contactPage();
                app.contact().addGroup(contact, groupToAdd);
                app.goTo().contactPage();
                app.contact().sortByGroupAll();
                GroupData deletedGroup = contact.getGroups().iterator().next();
                app.contact().removeGroup(contact, deletedGroup);  */
            }


        }



