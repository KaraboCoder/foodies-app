package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Recipe name is required.")
    private String recipeName;

    @NotNull(message = "Preparation time (in minutes) is required.")
    private int preparationTime; // minutes

    protected Recipes() {}

    public Recipes(String recipeName, int preparationTime) {
        this.recipeName = recipeName;
        this.preparationTime = preparationTime;
    }

}
