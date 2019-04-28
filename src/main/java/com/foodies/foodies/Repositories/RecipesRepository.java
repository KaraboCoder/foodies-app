package com.foodies.foodies.Repositories;

import com.foodies.foodies.Models.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends CrudRepository<Recipes, Long> {

}
