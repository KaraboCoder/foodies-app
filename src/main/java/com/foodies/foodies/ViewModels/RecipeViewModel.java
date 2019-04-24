package com.foodies.foodies.ViewModels;

import com.foodies.foodies.Models.Category;
import com.foodies.foodies.Models.Ingredient;
import com.foodies.foodies.Models.Recipe;

import java.util.List;

public class RecipeViewModel {
    private Recipe recipe;
    private Category category;
    private List<Ingredient> ingredients;


    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
