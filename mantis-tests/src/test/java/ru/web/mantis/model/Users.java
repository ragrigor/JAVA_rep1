package ru.web.mantis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class Users {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "username")
    public String username;
    @Column(name = "email")
    public String email;

   // public Users(int id, String username, String email) {
   //     this.id = id;
   //     this.username = username;
   //     this.email = email;
   // }


    //public Users() {
    //}

    public int getId() {
        return id;
    }

    public Users withId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Users withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users withEmail(String email) {
        this.email = email;
        return this;
    }
}