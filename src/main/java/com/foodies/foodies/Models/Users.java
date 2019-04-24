package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "First name is required.")
    private String firstName;

    @NotNull(message = "Last name is required.")
    private String lastName;

    @Email(message = "Invalid email address.")
    private String email;

    @NotNull(message = "Password is required.")
    @Size(min = 8, message = "Password should have at least 8 characters.")
    private String password;

    protected Users() {}

    public Users(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
