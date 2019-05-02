package com.foodies.foodies.Models;

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
    CommandLineRunner initDatabase(CategoriesRepository _categoriesRepo, IngredientsRepository _ingredientsRepo) {
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
                    out.println("Preloading " + _categoriesRepo.save(new Categories(addValue)));
                }catch (DataIntegrityViolationException e){
                    System.out.println("Category already exists");
                }
            }


//            out.println("Preloading " + _categoriesRepo.save(new Categories("Breakfast")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Dessert")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Beef")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Poultry")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Pork")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Seafood")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Main Dishes: Vegetarian")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Side Dishes: Vegetables")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Side Dishes: Other")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Appetizer")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Soup")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Salad")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Breads")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Rolls")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Miscellaneous")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Lunch")));
//            out.println("Preloading " + _categoriesRepo.save(new Categories("Canning / Freezing")));

            out.println("Preloading Ingredients");

            try {
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
            }catch (DataIntegrityViolationException e){
                System.out.println("Category already exists");
            }
        };
    }

    @Bean
    CommandLineRunner initUnits(UnitsRepository _unitsRepo) {
        return args -> {
//            _unitsRepo.deleteAll();

            out.println("Preloading Units");
            List<String> loadUnits = new ArrayList<String>();
            loadUnits.add("Teaspoon(s)");
            loadUnits.add("Tablespoon(s)");
            loadUnits.add("Cup(s)");
            loadUnits.add("mL");
            loadUnits.add("L");
            loadUnits.add("g");
            loadUnits.add("kg");
            loadUnits.add("Item Quantity");
            for (String addValue: loadUnits){
                try {
                    out.println("Preloading " + _unitsRepo.save(new Units(addValue)));
                }catch (DataIntegrityViolationException e){
                    System.out.println("Category already exists");
                }
            }
//            out.println("Preloading " + _unitsRepo.save(new Units("Teaspoon(s)")));
//            out.println("Preloading " + _unitsRepo.save(new Units("Tablespoon(s)")));
//            out.println("Preloading " + _unitsRepo.save(new Units("Cup(s)")));
//            out.println("Preloading " + _unitsRepo.save(new Units("mL")));
//            out.println("Preloading " + _unitsRepo.save(new Units("L")));
//            out.println("Preloading " + _unitsRepo.save(new Units("g")));
//            out.println("Preloading " + _unitsRepo.save(new Units("kg")));
//            out.println("Preloading " + _unitsRepo.save(new Units("Item Quantity")));

        };
    }
}
