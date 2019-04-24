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
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Recipe ID is required.")
    private Long recipeId;

    @NotNull(message = "Ingredient ID is required.")
    private Long ingredientId;

    @NotNull(message = "Unit ID is required.")
    private Long unitId;

    @NotNull(message = "Ingredient quantity is required.")
    private int quantity;

    protected RecipeIngredient() {}

    private RecipeIngredient(Long recipeId, Long ingredientId, Long unitId, int quantity) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.unitId = unitId;
        this.quantity = quantity;
    }
}
