package ru.web.adressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group1", "test1", "test2"));
        submitGroupCreation();
        returntoGroupPage();
    }

}
