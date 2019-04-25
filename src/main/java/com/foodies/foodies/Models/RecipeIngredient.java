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

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipeId", nullable = false)
    @NotNull(message = "Recipe ID is required.")
    private Recipes recipe;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ingredientId", nullable = false)
    @NotNull(message = "Ingredient ID is required.")
    private Ingredients ingredient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unitId", nullable = false)
    @NotNull(message = "Unit ID is required.")
    private Units unit;

    @NotNull(message = "Ingredient quantity is required.")
    private int quantity;

    protected RecipeIngredient() {}

    private RecipeIngredient(int quantity) {
        this.quantity = quantity;
    }
}
