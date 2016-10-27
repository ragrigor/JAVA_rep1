package ru.web.adressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name="addressbook")
public class ContactData {
    @Id
    private  int id = Integer.MAX_VALUE;
    @Expose
    private  String firstName;
    @Expose
    private  String lastName;
    @Expose
    @Type(type ="text")
    private  String address;
    @Expose
    @Column(name = "email")
    @Type(type ="text")
    private  String mail1;
    @Column(name = "email2")
    @Type(type ="text")
    private  String mail2;
    @Column(name = "email3")
    @Type(type ="text")
    private  String mail3;
    @Expose
    @Column(name = "home")
    @Type(type ="text")
    private  String phone1;
    @Column(name = "mobile")
    @Type(type ="text")
    private  String phone2;
    @Column(name = "work")
    @Type(type ="text")
    private  String phone3;
   /*
    @Expose
    @Column(name = "aday")
    @Type(type ="byte")
    private  String aDay;
    @Expose
    @Column(name = "amonth")
    private  String aMonth;
    @Expose
    @Column(name = "ayear")
    private  String aYear;
   */

    @Transient
    private  String allPhones;
    @Transient
    private  String allMails;
    @Transient
    private  String allDetails;
    @Transient
    @Column(name = "photo")
    private String photo;

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;

    /* private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;  */
    }

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
/*
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
*/
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

   /* public String getaDay() {
        return aDay;
    }

    public String getaMonth() {
        return aMonth;
    }

    public String getaYear() {
        return aYear;
    }
    */

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
