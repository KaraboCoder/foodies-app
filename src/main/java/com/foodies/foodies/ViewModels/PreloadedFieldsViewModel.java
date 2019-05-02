package com.foodies.foodies.ViewModels;

import com.foodies.foodies.Entities.RecipeCategoryDao;
import com.foodies.foodies.Models.CommonIngredient;
import com.foodies.foodies.Models.Units;

import java.util.List;

public class PreloadedFieldsViewModel {
    private List<Units> units;
    private List<RecipeCategoryDao> categories;
    private List<CommonIngredient> ingredients;

    public List<Units> getUnits() {
        return units;
    }

    public void setUnits(List<Units> units) {
        this.units = units;
    }

    public List<RecipeCategoryDao> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryDao> categories) {
        this.categories = categories;
    }

    public List<CommonIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CommonIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
