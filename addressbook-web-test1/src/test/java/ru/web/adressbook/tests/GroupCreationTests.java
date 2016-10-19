package ru.web.adressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.web.adressbook.model.GroupData;
import ru.web.adressbook.model.Groups;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName1("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[] {new GroupData().withName1("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[] {new GroupData().withName1("test3").withHeader("header3").withFooter("footer3")});
        return list.iterator();



    }

    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        //String [] names = new String[] {"test1", "test2", "test3"};
       // for(String name : names ){
           // GroupData group = new GroupData().withName1(name).withHeader(header).withFooter(footer); //.withHeader("test2").withFooter("test22");
            app.goTo().groupPage();
            Groups before = app.group().all();
            app.group().create(group);
            Groups after = app.group().all();
            assertThat(after.size(), equalTo(before.size() +1));
            assertThat(after, equalTo(
                    before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

      /*  int max = 0;
        for(GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        } */

        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        //assertEquals(before, after);


    }

}
