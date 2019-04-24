package com.foodies.foodies.Services.Definitions;

import com.foodies.foodies.DAO.IngredientRepository;
import com.foodies.foodies.Models.Ingredient;
import com.foodies.foodies.Services.IngredientServiceInterface;
import com.foodies.foodies.helpers.FoodiesGenericHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class IngredientService implements IngredientServiceInterface {

    private IngredientRepository _ingredientRepo;
    private Logger _logger = LoggerFactory.getLogger(RecipesService.class);

    @Autowired
    public IngredientService(IngredientRepository _ingredientRepo, Logger _logger) {
        this._ingredientRepo = _ingredientRepo;
        this._logger = _logger;
    }

    public Iterable<Ingredient> FetchAllIngredients() {
        try {
            return _ingredientRepo.findAll();
        } catch (Exception e) {
            _logger.error("Failed to retrieve recipe ingredients .Error details: " + e.getMessage());
            return null;
        }
    }

    public Optional<Ingredient> FetchCategoryByID(Long ID) {
        return _ingredientRepo.findById(ID);
    }

    public boolean CreateIngredient(Ingredient ingredient) {
        try {
            _ingredientRepo.save(ingredient);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to create ingredient. Error details: " + e.getMessage());
            return false;
        }
    }

    public boolean UpdateIngredient(Long ID, Ingredient updated) {
        if( !_ingredientRepo.existsById(ID)) return  false;

        try{
            var itemToUpdate = this.FetchCategoryByID(ID).orElseThrow();

            // TODO: Is there a better way?
            if(FoodiesGenericHelpers.IsNullOrEmpty( updated.getUnit_of_measurement()) ) itemToUpdate.setUnit_of_measurement(updated.getUnit_of_measurement());
            itemToUpdate.setQuantity( updated.getQuantity());
            if(FoodiesGenericHelpers.IsNullOrEmpty( updated.getMore_info() ) ) itemToUpdate.setMore_info(updated.getMore_info());

            _ingredientRepo.save(itemToUpdate);
            return  true;

        }catch (Exception e){
            _logger.error("Failed to update ingredient. Error details: " + e.getMessage());
            return  false;
        }
    }

    public boolean DeleteIngredient(Long ID) {
        try {
            _ingredientRepo.deleteById(ID);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to delete ingredient. Error details: " + e.getMessage());
            return false;
        }
    }
}
