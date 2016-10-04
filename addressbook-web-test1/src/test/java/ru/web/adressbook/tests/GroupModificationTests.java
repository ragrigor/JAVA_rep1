package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

/**
 * Created by Радочка on 24.09.2016.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "test2"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group3", null, "test100"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
