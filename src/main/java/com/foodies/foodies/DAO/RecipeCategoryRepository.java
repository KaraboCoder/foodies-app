package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.Category;
import org.springframework.data.repository.CrudRepository;

public interface RecipeCategoryRepository extends CrudRepository<Category, Long> {
}
