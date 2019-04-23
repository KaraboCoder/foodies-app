package com.foodies.foodies.restApi;

import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Services.IRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("recipes/{id}")
    public ResponseEntity RetriveRecipeByID(@PathVariable("id") Long ID){

        Recipe result = _recipeService.FindRecipeByID(ID).orElse(null);

        return result != null?  new ResponseEntity(result, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("recipes/create")
    public ResponseEntity<Recipe> CreateRecipe(@RequestBody Recipe recipe){

        boolean result = _recipeService.CreateRecipe(recipe);

        return this.GenerateNoContentResponse(result);
    }

    @PutMapping("recipes/{id}")
    public ResponseEntity<Recipe> UpdateRecipe(@PathVariable("id") Long ID, @RequestBody Recipe recipe){

        boolean result = _recipeService.UpdateRecipe(ID, recipe);

        return this.GenerateNoContentResponse(result);
    }

    @DeleteMapping("recipes/{id}")
    public ResponseEntity<Recipe> DeleteRecipe(@PathVariable("id") Long ID){

        boolean result = _recipeService.DeleteRecipe(0L, ID);

        return this.GenerateNoContentResponse(result);
    }



//Internal helpers
    private ResponseEntity GenerateNoContentResponse(boolean result){
        if(result == true){

            Object responseBody = new Object(){
                public final boolean succeeded = result;
                public final String message ="Operation completed successfully.";
            };
            return new ResponseEntity(responseBody, HttpStatus.NO_CONTENT);

        }else{
            Object responseBody = new Object(){
                public final boolean succeeded = result;
                public final String message ="Error: Please correct your schema and try again.";
            };
            return new ResponseEntity(responseBody, HttpStatus.BAD_REQUEST);
        }

    }


}
