package com.foodies.foodies.Services.Definitions;

import com.foodies.foodies.DAO.RecipeCategoryRepository;
import com.foodies.foodies.Models.Category;
import com.foodies.foodies.Services.IRecipeCatService;
import com.foodies.foodies.helpers.FoodiesGenericHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RecipeCategoryService implements IRecipeCatService {
    private RecipeCategoryRepository _categoriesRepo;
    private Logger _logger = LoggerFactory.getLogger(RecipesService.class);

    @Autowired
    public RecipeCategoryService(RecipeCategoryRepository _categoriesRepo, Logger _logger) {
        this._categoriesRepo = _categoriesRepo;
        this._logger = _logger;
    }

    public Iterable<Category> FetchAllCategories() {
        try {
            return _categoriesRepo.findAll();
        } catch (Exception e) {
            _logger.error("Failed to retrieve recipe categories .Error details: " + e.getMessage());
            return null;
        }
    }

    public Optional<Category> FetchCategoryByID(Long ID) {
        return _categoriesRepo.findById(ID);
    }

    public boolean CreateCategory(Category cat) {

        try {
            _categoriesRepo.save(cat);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to create shop item. Error details: " + e.getMessage());
            return false;
        }
    }

    public boolean UpdateCategory(Long ID, Category updated) {
        if( !_categoriesRepo.existsById(ID)) return  false;

        try{
            var itemToUpdate = this.FetchCategoryByID(ID).orElseThrow();

            // TODO: Is there a better way?
            if(FoodiesGenericHelpers.IsNullOrEmpty( updated.getName() ) ) itemToUpdate.setName(updated.getName());
            if(FoodiesGenericHelpers.IsNullOrEmpty( updated.getDescription() ) ) itemToUpdate.setDescription( updated.getDescription());

            _categoriesRepo.save(itemToUpdate);
            return  true;

        }catch (Exception e){
            _logger.error("Failed to update asset with Id: " + ID + ". Error details: " + e.getMessage());
            return  false;
        }
    }

    public boolean DeleteCategory(Long ID) {
        try {
            _categoriesRepo.deleteById(ID);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to category with ID: " + ID + ". Error details: " + e.getMessage());
            return false;
        }
    }
}
