package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Category;

import java.util.Optional;

public interface IRecipeCatService {

    Iterable<Category> FetchAllCategories();
    Optional<Category> FetchCategoryByID(Long ID);

    boolean CreateCategory(Category cat);
    boolean UpdateCategory(Long ID, Category cat);
    boolean DeleteCategory(Long ID);
}
