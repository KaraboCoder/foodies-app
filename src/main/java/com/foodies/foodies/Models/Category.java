package com.foodies.foodies.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @NotNull
    private String Name;
    private String Description;

    public Category() {
        this.Name = "All";
        this.Description = "Default category for all recipes";
    }

}
