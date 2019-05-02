package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeIngredientId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", nullable = false)
    @NotNull(message = "Recipe ID is required.")
    private Recipes recipe;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientId", nullable = false)
    @NotNull(message = "Ingredient ID is required.")
    private Ingredients ingredient;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "unitId", nullable = false)
    @NotNull(message = "Unit ID is required.")
    private Units unit;

    @NotNull(message = "Ingredient quantity is required.")
    private int quantity;

    protected RecipeIngredient() {}

    RecipeIngredient(int quantity) {
        this.quantity = quantity;
    }
}
