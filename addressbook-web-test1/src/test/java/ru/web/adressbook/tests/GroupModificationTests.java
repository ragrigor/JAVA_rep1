package ru.web.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;
import ru.web.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Радочка on 24.09.2016.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName1("group3").withFooter("test2"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName1("group3").withFooter("test100");
        app.group().modify(group);
        app.group().returntoGroupPage();
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

        //before.remove(modifiedGroup);
        //before.add(group);
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        //assertEquals(before, after);
    }


}
