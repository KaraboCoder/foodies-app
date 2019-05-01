package com.foodies.foodies.Services.contracts;

import com.foodies.foodies.Models.Recipes;

import java.util.Optional;

public interface IRecipeService {
    Iterable<Recipes> FetchAllRecipes();
    Iterable<Recipes> FetchUsersRecipes(Long UserId);
    Optional<Recipes> FindRecipeByID(Long ID);

    boolean CreateRecipe(Recipes recipe);
    boolean UpdateRecipe(Long ID, Recipes updated);
    boolean DeleteRecipe(Long userId, Long ID);
}
