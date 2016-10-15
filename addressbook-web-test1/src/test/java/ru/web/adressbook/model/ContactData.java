package ru.web.adressbook.model;

public class ContactData {
    private  int id = Integer.MAX_VALUE;
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String mail1;
    private  String mail2;
    private  String mail3;
    private  String phone1;
    private  String phone2;
    private  String phone3;
    private  String aDay;
    private  String aMonth;
    private  String aYear;
    private  String allPhones;
    private  String allMails;
    private  String allDetails;

    public String getAllDetails() {
        return allDetails;
    }

    public ContactData withAllDetails(String allDetails) {
        this.allDetails = allDetails;
        return this;
    }




    public String getAllMails() {
        return allMails;
    }

    public ContactData withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }



 /*   public ContactData(int id, String firstName, String lastName, String address, String mail1, String mail2, String phone1, String phone2, String phone3, String aDay, String aMonth, String aYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.aDay = aDay;
        this.aMonth = aMonth;
        this.aYear = aYear;
    }

    public ContactData(String firstName, String lastName, String address, String mail1, String mail2, String phone1, String phone2, String phone3, String aDay, String aMonth, String aYear) {
        this.aYear = aYear;
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.aDay = aDay;
        this.aMonth = aMonth;
    }   */

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMail1(String mail1) {
        this.mail1 = mail1;
        return this;
    }

    public ContactData withMail2(String mail2) {
        this.mail2 = mail2;
        return this;
    }

    public String getMail3() {
        return mail3;
    }

    public ContactData withMail3(String mail3) {
        this.mail3 = mail3;
        return this;
    }

    public ContactData withPhone1(String phone1) {
        this.phone1 = phone1;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public ContactData withPhone3(String phone3) {
        this.phone3 = phone3;
        return this;
    }

    public ContactData withADay(String aDay) {
        this.aDay = aDay;
        return this;
    }

    public ContactData withAMonth(String aMonth) {
        this.aMonth = aMonth;
        return this;
    }

    public ContactData withAYear(String aYear) {
        this.aYear = aYear;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getaDay() {
        return aDay;
    }

    public String getaMonth() {
        return aMonth;
    }

    public String getaYear() {
        return aYear;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }


}
