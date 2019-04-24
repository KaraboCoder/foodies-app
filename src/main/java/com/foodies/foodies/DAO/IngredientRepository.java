package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
