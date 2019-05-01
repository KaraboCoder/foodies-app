package com.foodies.foodies.RestAPI;

import com.foodies.foodies.Entities.RecipeDao;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeRestService implements IRecipe {
    @Autowired
    private RecipeReposirtory _recipeRepo;

    @Override
    public List<RecipeViewModel> FetchAllRecipes() {
        Iterable<RecipeDao> recipeList = _recipeRepo.findAll();
        List<RecipeViewModel> results = new ArrayList<>();

        recipeList.forEach( recipeDao -> {
            var recipeVm = new RecipeViewModel(){
                {
                    id = recipeDao.getId();
                    title = recipeDao.getTitle();
                    description = recipeDao.getDescription();
                    display_pic_url = recipeDao.getDisplay_pic_url();
                    time_to_prepare = recipeDao.getTime_to_prepare();
                    difficulty_level = recipeDao.getDifficulty_level();
                    category = recipeDao.getCategory();
                    instructions = recipeDao.getInstructions();
                    ingredients = recipeDao.getIngredients();
                }
            };

            results.add(recipeVm);
        });

        return results;
    }

    @Override
    public Iterable<RecipeViewModel> FetchUsersRecipes(Long UserId) {
        return null;
    }

    @Override
    public Optional<RecipeViewModel> FindRecipeByID(Long ID) {
        return Optional.empty();
    }

    @Override
    public boolean CreateRecipe(RecipeViewModel recipe) {
        return false;
    }

    @Override
    public boolean UpdateRecipe(Long ID, RecipeViewModel updated) {
        return false;
    }

    @Override
    public boolean DeleteRecipe(Long userId, Long ID) {
        return false;
    }
}
