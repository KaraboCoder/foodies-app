package com.foodies.foodies.Services.Definitions;

import com.foodies.foodies.DAO.RecipesRepository;
import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Services.IRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipesService implements IRecipesService {

    private RecipesRepository _repo;

    @Autowired
    public RecipesService(RecipesRepository repo) {
        this._repo = repo;
    }


    @Override
    public Iterable<Recipe> FetchAllRecipes() {
        return _repo.findAll();
    }

    @Override
    public Iterable<Recipe> FetchUsersRecipes(Long UserId) {
        return null;
    }

    @Override
    public Optional<Recipe> FindRecipeByID(Long ID) {
        return _repo.findById(ID);
    }

    @Override
    public boolean CreateRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean UpdateRecipe(Long ID, Recipe updated) {
        return false;
    }

    @Override
    public boolean DeleteRecipe(Long userId, Long ID) {
        return false;
    }
}
