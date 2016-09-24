package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

/**
 * Created by Радочка on 24.09.2016.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group1", "test1", "test2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returntoGroupPage();
    }
}
