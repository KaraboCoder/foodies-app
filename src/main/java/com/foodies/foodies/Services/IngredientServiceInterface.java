package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Ingredient;

import java.util.Optional;

public interface IngredientServiceInterface {

    Iterable<Ingredient> FetchAllIngredients();
    Optional<Ingredient> FetchCategoryByID(Long ID);

    boolean CreateIngredient(Ingredient ingredient);
    boolean UpdateIngredient(Long ID, Ingredient ingredient);
    boolean DeleteIngredient(Long ID);
}
