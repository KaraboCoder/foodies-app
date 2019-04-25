package com.foodies.foodies.restApi;

import com.foodies.foodies.Models.Category;
import com.foodies.foodies.Models.Ingredient;
import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Models.ShoppingListItem;
import com.foodies.foodies.Services.IRecipesService;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")

@Api(value="Recipe management system")
public class RecipesController {
    private IRecipesService _recipeService;

    @Autowired
    public RecipesController(IRecipesService recipeService) {
        this._recipeService = recipeService;
    }

    @GetMapping("/recipes")
    @ApiOperation(value = "List all saved recipes")
    public ResponseEntity<List<Recipe>> RetriveAllRecipes(){

        List<Recipe> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }


    @GetMapping("recipes/{id}")
    public ResponseEntity<Recipe> RetriveRecipeByID(@PathVariable("id") Long ID){

        Recipe result = _recipeService.FindRecipeByID(ID).orElse(null);

        return result != null?  new ResponseEntity(result, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("recipes/create")
    @ResponseBody
    public ResponseEntity CreateRecipe(@RequestBody @Valid RecipeViewModel recipe){

        boolean result = _recipeService.CreateRecipe(recipe);

        return this.GenerateNoContentResponse(result);
    }

    @PutMapping("recipes/{id}")
    public ResponseEntity UpdateRecipe(@PathVariable("id") Long ID, @RequestBody Recipe recipe){

        boolean result = _recipeService.UpdateRecipe(ID, recipe);

        return this.GenerateNoContentResponse(result);
    }

    @DeleteMapping("recipes/{id}")
    public ResponseEntity DeleteRecipe(@PathVariable("id") Long ID){

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
