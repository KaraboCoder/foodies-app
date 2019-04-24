package com.foodies.foodies.Services.Definitions;

import com.foodies.foodies.DAO.IngredientRepository;
import com.foodies.foodies.DAO.RecipeCategoryRepository;
import com.foodies.foodies.DAO.RecipesRepository;
import com.foodies.foodies.DAO.ShoppingItemRepository;
import com.foodies.foodies.Models.Category;
import com.foodies.foodies.Models.Ingredient;
import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Models.ShoppingListItem;
import com.foodies.foodies.Services.IRecipesService;
import com.foodies.foodies.helpers.FoodiesGenericHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class RecipesService implements IRecipesService {

    private RecipesRepository _repo;

//    TODO: CREATE SERVICES FOR THESE
    private RecipeCategoryRepository _categoriesRepo;
    private IngredientRepository _ingredientRepo;
    private ShoppingItemRepository _itemsRepo;

    private Logger _logger = LoggerFactory.getLogger(RecipesService.class);

    @Autowired
    public RecipesService(RecipesRepository repo,
                          RecipeCategoryRepository catRepo,
                          IngredientRepository ingredientRepo,
                          ShoppingItemRepository itemsRepo) {
        this._repo = repo;
        this._categoriesRepo = catRepo;
        this._ingredientRepo = ingredientRepo;
        this._itemsRepo = itemsRepo;
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
        try {
            var category = new Category();
            _categoriesRepo.save(category);
            recipe.setCategory(category);

            var item = new ShoppingListItem("mm", 11);
            _itemsRepo.save(item);
            var ingredient = new Ingredient(item, "mm", 10,null, null);
            _ingredientRepo.save(ingredient);
            recipe.getIngredients().add(ingredient);

            _repo.save(recipe);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to created recipe: " + recipe.toString() + ". Error details: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean UpdateRecipe(Long ID, Recipe updated) {

        if( !_repo.existsById(ID)) return  false;

        try{
            var recipeToUpdate = this.FindRecipeByID(ID).orElseThrow();

            if(FoodiesGenericHelpers.IsNullOrEmpty(updated.getTitle()) ) recipeToUpdate.setTitle(updated.getTitle());

            _repo.save(recipeToUpdate);
            return  true;

        }catch (Exception e){
            // LOG Error message
            _logger.error("Failed to update asset with Id: " + ID + ". Error details: " + e.getMessage());
            return  false;
        }

    }

    @Override
    public boolean DeleteRecipe(Long userId, Long ID) {

        try {
            _repo.deleteById(ID);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to delete recipe with ID: " + ID + ". Error details: " + e.getMessage());
            return false;
        }
    }
}
