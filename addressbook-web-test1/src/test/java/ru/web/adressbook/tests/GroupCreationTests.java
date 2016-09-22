package ru.web.adressbook.tests;

import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("group1", "test1", "test2"));
        app.submitGroupCreation();
        app.returntoGroupPage();
    }

}
