package com.foodies.foodies.Repositories;

import com.foodies.foodies.Entities.RecipeDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeDao, Long> {
}
