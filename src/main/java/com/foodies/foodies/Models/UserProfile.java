package com.foodies.foodies.Models;

import javax.persistence.*;

@Entity
@Table(name = "userprofiles")
public class UserProfile{
    @Id
    private long ID;
    private String Email;
    private String  Name;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
