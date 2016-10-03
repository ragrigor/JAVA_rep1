package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "test2"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }


}
