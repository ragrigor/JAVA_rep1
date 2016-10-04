package ru.web.adressbook.model;

public class GroupData {
    private final String id;
    private final String name1;
    private final String name2;
    private final String name3;


    public GroupData(String id, String name1, String name2, String name3) {
        this.id = id;

        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }

    public GroupData(String name1, String name2, String name3) {
        this.id = null;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }

    public String getId() {
        return id;
    }
    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name1='" + name1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
        return name1 != null ? name1.equals(groupData.name1) : groupData.name1 == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name1 != null ? name1.hashCode() : 0);
        return result;
    }
}
