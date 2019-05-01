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
    CommandLineRunner initCategoriesDB(CategoriesRepository _categoriesRepo) {
        return args -> {
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
        };
    }

    @Bean
    CommandLineRunner initIngredientsDB(CategoriesRepository _categoriesRepo) {
        return args -> {
            out.println("Preloading " + _categoriesRepo.save(new Categories("Breakfast")));
        };
    }

    @Bean
    CommandLineRunner initDB(CategoriesRepository _categoriesRepo) {
        return args -> {
            out.println("Preloading " + _categoriesRepo.save(new Categories("Breakfast")));
        };
    }
}
