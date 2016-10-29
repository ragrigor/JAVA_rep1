package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;
import ru.web.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    //check in UI
   /* public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName1("group3").withFooter("test2"));
        }
    }      */
    public void ensurePreconditions() {
        if(app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName1("group3").withFooter("test2"));
        }
    }

    @Test
    public void testGroupDeletion() {

       // Groups before = app.group().all();  if checked in UI
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        app.group().returntoGroupPage();
        Groups after = app.db().groups();
       // Groups after = app.group().all();   if checked in UI
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.without(deletedGroup)));
       // Assert.assertEquals(before, after);
    }

}
