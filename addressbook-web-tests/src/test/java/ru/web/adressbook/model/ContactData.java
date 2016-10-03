package ru.web.adressbook.model;

public class ContactData {
    private final String name1;
    private final String name2;
    private final String address;
    private final String mail1;
    private final String mail2;
    private final String phone1;
    private final String phone2;
    private final String phone3;

    public ContactData(String name1, String name2, String address, String mail1, String mail2, String phone1, String phone2, String phone3) {
        this.name1 = name1;
        this.name2 = name2;
        this.address = address;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
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
}
