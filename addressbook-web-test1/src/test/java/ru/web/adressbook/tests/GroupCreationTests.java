package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("group1", "test1", "test2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returntoGroupPage();
    }

}
