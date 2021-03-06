package ru.web.adressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name="group_list")
public class GroupData {
    @XStreamOmitField
    @Id
    @Column(name="group_id")
    private int id = Integer.MAX_VALUE;
    @Column(name="group_name")
    private  String name1;
    @Column(name="group_header")
    @Type(type="text")
    private  String header;
    @Column(name="group_footer")
    @Type(type="text")
    private  String footer;

    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts= new HashSet<ContactData>();

    public Contacts getContacts() {
        return new Contacts(contacts);
    }
    /* public GroupData(int id, String name1, String header, String footer) {
        this.id = id;
        this.name1 = name1;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String name1, String header, String footer) {
        this.id = Integer.MAX_VALUE;
        this.name1 = name1;
        this.header = header;
        this.footer = footer;
    }  */

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public String getName1() {
        return name1;
    }

    public GroupData withName1(String name1) {
        this.name1 = name1;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        if (name1 != null ? !name1.equals(groupData.name1) : groupData.name1 != null) return false;
        if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
        return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name1 != null ? name1.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (footer != null ? footer.hashCode() : 0);
        return result;
    }
}
