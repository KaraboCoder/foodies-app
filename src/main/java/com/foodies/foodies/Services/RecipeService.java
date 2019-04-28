package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Recipes;
import com.foodies.foodies.Repositories.RecipesRepository;
import com.foodies.foodies.Services.contracts.IRecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService implements IRecipeService {
    private Logger _logger = LoggerFactory.getLogger(RecipeService.class);

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
        return _recipesRepo.findById(ID);
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
        try {
            _recipesRepo.deleteById(ID);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to delete recipe with ID: " + ID + ". Error details: " + e.getMessage());
            return false;
        }
    }
}
