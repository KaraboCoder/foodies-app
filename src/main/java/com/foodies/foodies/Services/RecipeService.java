package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Recipes;
import com.foodies.foodies.Repositories.RecipesRepository;
import com.foodies.foodies.Services.contracts.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService implements IRecipeService {
    @Autowired
    private RecipesRepository _recipesRepo;

    @Override
    public Iterable<Recipes> FetchAllRecipes() {
        return this._recipesRepo.findAll();
    }

    @Override
    public Iterable<Recipes> FetchUsersRecipes(Long UserId) {
        return null;
    }

    @Override
    public Optional<Recipes> FindRecipeByID(Long ID) {
        return Optional.empty();
    }

    @Override
    public boolean CreateRecipe(Recipes recipe) {
        return false;
    }

    @Override
    public boolean UpdateRecipe(Long ID, Recipes updated) {
        return false;
    }

    @Override
    public boolean DeleteRecipe(Long userId, Long ID) {
        return false;
    }
}
