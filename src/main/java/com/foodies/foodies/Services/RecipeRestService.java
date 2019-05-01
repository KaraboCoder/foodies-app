package com.foodies.foodies.Services;

import com.foodies.foodies.Entities.InstructionDao;
import com.foodies.foodies.Entities.RecipeDao;
import com.foodies.foodies.Repositories.IngredientDaoRepository;
import com.foodies.foodies.Repositories.InstructionDaoRepository;
import com.foodies.foodies.Repositories.RecipeCategoryDaoRepository;
import com.foodies.foodies.Repositories.RecipeReposirtory;
import com.foodies.foodies.Services.contracts.IRecipeService;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeRestService implements IRecipeService {

    private RecipeReposirtory _recipeRepo;
    private RecipeCategoryDaoRepository _categoriesRepo;
    private IngredientDaoRepository _ingredientsRepo;
    private InstructionDaoRepository _instructRepo;
    private Logger _logger = LoggerFactory.getLogger(RecipeRestService.class);

    @Autowired
    public RecipeRestService(RecipeReposirtory _recipeRepo,
                             RecipeCategoryDaoRepository _categoriesRepo,
                             InstructionDaoRepository instr,
                             IngredientDaoRepository _ingredientsRepo) {
        this._recipeRepo = _recipeRepo;
        this._categoriesRepo = _categoriesRepo;
        this._ingredientsRepo = _ingredientsRepo;
        this._instructRepo = instr;
    }

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
        try {
            var recipeDao = new RecipeDao();
            recipeDao.setTitle( recipe.title );

            var category = recipe.category;
            _categoriesRepo.save( category );
            recipeDao.setCategory(category);

            for(InstructionDao instructItem: recipe.instructions ) {
                _instructRepo.save(instructItem);
                recipeDao.getInstructions().add(instructItem);
            }

            for(var item: recipe.ingredients ){
                _ingredientsRepo.save( item );
                recipeDao.getIngredients().add( item );
            }

            _recipeRepo.save(recipeDao);
            return true;

        } catch (Exception e) {
            _logger.error("Failed to created recipe: " + recipe.toString() + ". Error details: " + e.getMessage());
            return false;
        }
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
