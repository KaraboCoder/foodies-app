package com.foodies.foodies.RestAPI;

import com.foodies.foodies.Entities.RecipeDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeReposirtory extends CrudRepository<RecipeDao, Long> {
}
