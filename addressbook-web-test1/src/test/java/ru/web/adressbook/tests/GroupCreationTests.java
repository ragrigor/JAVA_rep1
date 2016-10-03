package ru.web.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("group2", "test2", "test22"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before +1);


    }

}
