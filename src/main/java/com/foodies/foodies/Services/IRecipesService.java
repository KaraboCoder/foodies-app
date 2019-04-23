package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Recipe;

public interface IRecipesService {

    Iterable<Recipe> FetchAllRecipes();
    Iterable<Recipe> FetchUsersRecipes(Long UserId);
    Recipe FindRecipeByID(Long ID);

    boolean CreateRecipe(Recipe recipe);
    boolean UpdateRecipe(Long ID, Recipe updated);
    boolean DeleteRecipe(Long userId, Long ID);
}
