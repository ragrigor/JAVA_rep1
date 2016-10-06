package ru.web.adressbook.model;

public class ContactData {
    private  int id;
    private final String name1;
    private final String name2;
    private final String address;
    private final String mail1;
    private final String mail2;
    private final String phone1;
    private final String phone2;
    private final String phone3;

    public ContactData(int id, String name1, String name2, String address, String mail1, String mail2, String phone1, String phone2, String phone3) {
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.address = address;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
    }

    public ContactData(String name1, String name2, String address, String mail1, String mail2, String phone1, String phone2, String phone3) {
        this.id = 0;
        this.name1 = name1;
        this.name2 = name2;
        this.address = address;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getAddress() {
        return address;
    }

    public String getMail1() {
        return mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name1 != null ? !name1.equals(that.name1) : that.name1 != null) return false;
        return name2 != null ? name2.equals(that.name2) : that.name2 == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name1 != null ? name1.hashCode() : 0);
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        return result;
    }
}
