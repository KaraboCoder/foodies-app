package com.foodies.foodies.Services.contracts;

import com.foodies.foodies.Entities.RecipeDao;
import com.foodies.foodies.ViewModels.RecipeViewModel;

import java.util.Optional;

public interface IRecipeService {
    Iterable<RecipeViewModel> FetchAllRecipes();
    Iterable<RecipeViewModel> FetchUsersRecipes(Long UserId);
    Optional<RecipeViewModel> FindRecipeByID(Long ID);

    boolean CreateRecipe(RecipeViewModel recipe);
    boolean UpdateRecipe(Long ID, RecipeViewModel updated);
    boolean DeleteRecipe(Long userId, Long ID);
}
