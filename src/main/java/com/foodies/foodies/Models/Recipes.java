package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "recipes")
public class Recipes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;

    @NotBlank(message = "Recipe name is required.")
    private String recipeName;

    @NotNull(message = "Preparation time (in minutes) is required.")
    private int preparationTime; // minutes

    private boolean selected;

    //#region constructors
    public Recipes() {}

    Recipes(String recipeName, int preparationTime) {
        this.recipeName = recipeName;
        this.preparationTime = preparationTime;
        this.selected = false;
    }
    //#endregion


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRecipeName() {
//        return recipeName;
//    }
//
//    public void setRecipeName(String recipeName) {
//        this.recipeName = recipeName;
//    }
//
//    public int getPreparationTime() {
//        return preparationTime;
//    }
//
//    public void setPreparationTime(int preparationTime) {
//        this.preparationTime = preparationTime;
//    }
}
