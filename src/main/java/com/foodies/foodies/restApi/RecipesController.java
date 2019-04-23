package com.foodies.foodies.restApi;

import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Services.IRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class RecipesController {
    private IRecipesService _recipeService;

    @Autowired
    public RecipesController(IRecipesService recipeService) {
        this._recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> RetriveAllRecipes(){

        List<Recipe> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }
}
