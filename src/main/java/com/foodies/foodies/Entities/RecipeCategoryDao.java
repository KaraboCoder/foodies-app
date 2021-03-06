package com.foodies.foodies.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class RecipeCategoryDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description;

    public RecipeCategoryDao() {
    }

    public RecipeCategoryDao(@NotNull String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
