package com.foodies.foodies.Models;

import com.foodies.foodies.Entities.IngredientDao;
import com.foodies.foodies.Entities.RecipeCategoryDao;
import lombok.extern.slf4j.Slf4j;

import static java.lang.System.out;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.foodies.foodies.Repositories.*;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(RecipeCategoryDaoRepository  _categoriesRepo,
                                   CommonIngredientRepository _ingredientsRepo) {
        return args -> {

            out.println("Preloading Categories");

            List<String> loadCategories = new ArrayList<String>();
            loadCategories.add("Breakfast");
            loadCategories.add("Dessert");
            loadCategories.add("Main Dishes: Beef");
            loadCategories.add("Main Dishes: Poultry");
            loadCategories.add("Main Dishes: Pork");
            loadCategories.add("Main Dishes: Seafood");
            loadCategories.add("Main Dishes: Vegetarian");
            loadCategories.add("Side Dishes: Vegetables");
            loadCategories.add("Side Dishes: Other");
            loadCategories.add("Appetizer");
            loadCategories.add("Soup");
            loadCategories.add("Salad");
            loadCategories.add("Breads");
            loadCategories.add("Rolls");
            loadCategories.add("Lunch");
            loadCategories.add("Canning / Freezing");
            loadCategories.add("Miscellaneous");
            loadCategories.add("Ingredient: Meat");
            loadCategories.add("Ingredient: Produce");
            loadCategories.add("Ingredient: Dry / Baking");
            loadCategories.add("Ingredient: Dairy");

            for (String addValue: loadCategories){
                try {
                    out.println("Insert category: " + _categoriesRepo.save(new RecipeCategoryDao(addValue)));
                }catch (DataIntegrityViolationException e){
                    System.out.println("Category already exists");
                }
            }


            try {
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Beef")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Poultry")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Pork")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Seafood")));

                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Apple") ));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Banana")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Potato")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Spinach")));

                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Flour")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Icing Sugar")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Sugar")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Pasta")));

                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Milk")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Butter")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Eggs")));
                out.println("Preloading " + _ingredientsRepo.save(new CommonIngredient("Yogurt")));
            }catch (DataIntegrityViolationException e){
                System.out.println("Category already exists");
            }
        };
    }
//
    @Bean
    CommandLineRunner initUnits(UnitsRepository _unitsRepo) {
        return args -> {
            _unitsRepo.deleteAll();

            out.println("Seeding Units...");
            List<String> loadUnits = new ArrayList<String>();
            loadUnits.add("Teaspoon");
            loadUnits.add("Tablespoon");
            loadUnits.add("Cup");
            loadUnits.add("mL");
            loadUnits.add("L");
            loadUnits.add("g");
            loadUnits.add("kg");
            loadUnits.add("Item Quantity");

            for (String addValue: loadUnits){
                try {
                    out.println("Insert " + _unitsRepo.save(new Units(addValue)));
                }catch (DataIntegrityViolationException e){
                    System.out.println("Category already exists");
                }
            }

        };
    }
}
