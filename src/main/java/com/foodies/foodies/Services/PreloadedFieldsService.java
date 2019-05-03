package com.foodies.foodies.Services;

import com.foodies.foodies.Entities.RecipeCategoryDao;
import com.foodies.foodies.Models.CommonIngredient;
import com.foodies.foodies.Models.Units;
import com.foodies.foodies.Repositories.CommonIngredientRepository;
import com.foodies.foodies.Repositories.RecipeCategoryDaoRepository;
import com.foodies.foodies.Repositories.UnitsRepository;
import com.foodies.foodies.Services.contracts.IPreloadedFieldsService;
import com.foodies.foodies.Services.contracts.IRecipeService;
import com.foodies.foodies.ViewModels.PreloadedFieldsViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PreloadedFieldsService implements IPreloadedFieldsService {
    private UnitsRepository _unitsRepo;
    private RecipeCategoryDaoRepository _categoryRepo;
    private CommonIngredientRepository _ingredientRepo;

    @Autowired
    public PreloadedFieldsService(UnitsRepository _unitsRepo,
                                  RecipeCategoryDaoRepository _categoryRepo,
                                  CommonIngredientRepository _ingredientRepo) {
        this._unitsRepo = _unitsRepo;
        this._categoryRepo = _categoryRepo;
        this._ingredientRepo = _ingredientRepo;
    }


    @Override
    public PreloadedFieldsViewModel FetchAll() {
        PreloadedFieldsViewModel result = new PreloadedFieldsViewModel();

        ArrayList<CommonIngredient> Ingredients = new ArrayList<>();
        ArrayList<Units> Units = new ArrayList<>();
        ArrayList<RecipeCategoryDao> Categories = new ArrayList<>();

        _ingredientRepo.findAll().forEach( item -> Ingredients.add(item));
        _categoryRepo.findAll().forEach(item -> Categories.add(item));
        _unitsRepo.findAll().forEach( item -> Units.add( item ));

        result.setCategories(Categories);
        result.setUnits(Units);
        result.setIngredients(Ingredients);
        return result;
    }
}
