package ru.web.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.web.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Радочка on 22.09.2016.
 */
public class GroupHelper  extends HelperBase{

    public GroupHelper(WebDriver wd) {
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
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));

    }

    public void selectGroup(int index) {
        wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));

    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntoGroupPage();
    }
    public void modify(List<GroupData> before, GroupData group) {
        selectGroup(before.size() - 1);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public int getGroupCount() {
        return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name  = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName1(name);
            groups.add(group);
        }

        return groups;
    }
}
