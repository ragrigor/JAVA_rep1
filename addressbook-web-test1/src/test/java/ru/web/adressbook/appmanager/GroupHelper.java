package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.web.adressbook.model.GroupData;

/**
 * Created by Радочка on 22.09.2016.
 */
public class GroupHelper  extends HelperBase{

    public GroupHelper(FirefoxDriver wd) {
        super(wd);

    }

    public void returntoGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName1());
        type(By.name("group_header"), groupData.getName2());
        type(By.name("group_footer"), groupData.getName3());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));

    }

    public void selectGroup() {

        click(By.xpath("//input[@name='selected[]']"));
    }

    public void initGroupModification() {
        click(By.name("edit"));

    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
