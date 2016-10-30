package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.Contacts;
import ru.web.adressbook.model.GroupData;
import ru.web.adressbook.model.Groups;

/**
 * Created by Радочка on 30.10.2016.
 */
public class ContactAddToGroupTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        // if contact exists
        if(app.db().contacts().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstName("M_test").withLastName("test").withAddress("2 TestStreet")
                    .withMail1("test22@gmail.com").withMail2("test22@gmail.com").withMail3("test22@gmail.com")
                    .withPhone1("456-444").withPhone2("456-555").withPhone3("456-666"));
        }

        // if group exists
        if(app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName1("group3").withHeader("test").withFooter("test"));
        }
    }



    @Test
    public void testContactAddToGroup() {

        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        if(contact.getGroups().size() == 0){
            // if(contact.getGroups().size() == 0){
            app.goTo().contactPage();
            app.contact().selectContactById(contact.getId());
            app.contact().selectGroupFromList(group);
            app.contact().submitAddingToGroup();

        }



     /*   Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        app.goTo().contactPage();
        app.contact().addToGroup(contact, group);  */
    }
}
