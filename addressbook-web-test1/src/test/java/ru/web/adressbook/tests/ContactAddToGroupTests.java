package ru.web.adressbook.tests;

import org.hibernate.Session;
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
public class ContactAddToGroupTests extends TestBase {

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
    }


    @Test
    public void testContactAddToGroup() {

        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        Groups allGroups = app.db().groups();

        if (contact.getGroups().size() == 0) {                          //contact is not included into any groups
            GroupData anyGroup = allGroups.iterator().next();
            app.contact().addGroup(contact, anyGroup);
            ContactData contactWithGroup = contact;
            assertThat(contactWithGroup.getGroups().size(), equalTo(contact.getGroups().size()+1));

           // Assert.assertEquals(contact.getGroups().size() + 1 after);
        } else if (contact.getGroups().size() != 0 &&                   //contact is  included into one/several groups
                contact.getGroups().size() < allGroups.size()) {
            Groups remainingGroups = app.db().groups();
            remainingGroups.removeAll(contact.getGroups());  //filter the list (only not added groups left)
            GroupData group = remainingGroups.iterator().next();
            app.contact().addGroup(contact, group);
            ContactData contactWithGroup = contact;
            assertThat(contactWithGroup.getGroups().size(), equalTo(contact.getGroups().size()+1));

        } else {                                                       //contacts is  included into all groups,
            app.goTo().groupPage();
            GroupData newGroup = new GroupData().withName1("group5").withHeader("test").withFooter("test"); //create new group
            app.group().create(newGroup);
            app.goTo().contactPage();
            app.contact().addGroup(contact, newGroup);
            ContactData contactWithGroup = contact;
            assertThat(contactWithGroup.getGroups().size(), equalTo(contact.getGroups().size()+1));
        }
    }
}

       //groups.removeAll(contact.getGroups());  //filter the list (only not added groups left)
       // System.out.println(groups);
       // System.out.println(contact.getGroups());
       // GroupData group = groups.iterator().next();
       // System.out.println(group);

     /*   List<ContactData> found = before.stream()
                .filter(c->c.getGroups().size()!=0 && c.getGroups().size() < groups.size())
                .collect(Collectors.toList());
        contact = found.iterator().next();  */

       // if(contact.getGroups().size() != 0 &&
       //         contact.getGroups().size() < allGroups.size()){
            // if(contact.getGroups().size() == 0){
       //     app.goTo().contactPage();
       //     app.contact().addGroup(contact, group);
           // app.contact().selectContactById(contact.getId());
           // app.contact().selectGroupFromList(group);
          //  app.contact().submitAddingToGroup();
      //  }else if (contact.getGroups().size() == 0){
     //   }contact.getGroups().toArray(). {

      /*  } else if (contact.getGroups().size() == allGroups.size()){
            app.goTo().groupPage();
            GroupData newGroup = new GroupData().withName1("group103").withHeader("test").withFooter("test");
            app.group().create(newGroup);
            app.contact().addGroup(contact, newGroup );
        }

      //  for(contact : before){
      //      if(contact.getGroups().)
      //      if (g.getId() > max){
      //          max = g.getId();
            }
        }



      Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        app.goTo().contactPage();
        app.contact().addToGroup(contact, group);  */