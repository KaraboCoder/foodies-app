package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.ViewModels.RecipeViewModel;

import java.util.Optional;

public interface IRecipesService {

    Iterable<Recipe> FetchAllRecipes();
    Iterable<Recipe> FetchUsersRecipes(Long UserId);
    Optional<Recipe> FindRecipeByID(Long ID);

    boolean CreateRecipe(RecipeViewModel recipe);
    boolean UpdateRecipe(Long ID, Recipe updated);
    boolean DeleteRecipe(Long userId, Long ID);
}
