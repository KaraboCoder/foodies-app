package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecipesRepository extends PagingAndSortingRepository<Recipe, Long> {
}
