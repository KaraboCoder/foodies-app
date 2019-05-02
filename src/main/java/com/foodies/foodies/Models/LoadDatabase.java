package com.foodies.foodies.Models;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.out;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foodies.foodies.Models.Categories;

import com.foodies.foodies.Repositories.*;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CategoriesRepository _categoriesRepo, IngredientsRepository _ingredientsRepo) {
        return args -> {
            _ingredientsRepo.deleteAll();
            _categoriesRepo.deleteAll();

            out.println("Preloading Categories");
            out.println("Preloading " + _categoriesRepo.save(new Categories("Breakfast")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Dessert")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Beef")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Poultry")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Pork")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Seafood")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Vegetarian")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Side Dishes: Vegetables")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Side Dishes: Other")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Appetizer")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Soup")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Salad")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Breads")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Rolls")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Miscellaneous")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Lunch")));
            out.println("Preloading " + _categoriesRepo.save(new Categories("Canning / Freezing")));

            out.println("Preloading Ingredients");
            Categories meatCategory = _categoriesRepo.save(new Categories("Ingredient: Meat"));
            Categories produceCategory = _categoriesRepo.save(new Categories("Ingredient: Produce"));
            Categories bakingCategory = _categoriesRepo.save(new Categories("Ingredient: Dry / Baking"));
            Categories dairyCategory = _categoriesRepo.save(new Categories("Ingredient: Dairy"));

            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Beef", meatCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Poultry", meatCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Pork", meatCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Seafood", meatCategory)));

            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Apple", produceCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Banana", produceCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Potato", produceCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Spinach", produceCategory)));

            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Flour", bakingCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Icing Sugar", bakingCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Sugar", bakingCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Pasta", bakingCategory)));

            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Milk", dairyCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Butter", dairyCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Eggs", dairyCategory)));
            out.println("Preloading " + _ingredientsRepo.save(new Ingredients("Yogurt", dairyCategory)));
        };
    }
}
