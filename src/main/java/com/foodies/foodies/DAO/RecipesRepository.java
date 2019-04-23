package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipesRepository extends PagingAndSortingRepository<Recipe, Long> {
}
