package com.foodies.foodies.RestAPI;

import com.foodies.foodies.Services.contracts.IRecipeService;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class RecipeRestController {
    @Autowired
    private IRecipeService _recipeApiService;

    @GetMapping("/recipes/all")
    public ResponseEntity<List<RecipeViewModel>> GetAll(){
        var responseBody = _recipeApiService.FetchAllRecipes();


        return new ResponseEntity(responseBody, HttpStatus.OK);
    }


    @GetMapping("/recipes/{recipeId}")
    public  ResponseEntity<RecipeViewModel> GetById(@PathVariable("recipeId") Long ID){
        var result = _recipeApiService.FindRecipeByID(ID);

        return result != null?  new ResponseEntity(result, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }



    @PostMapping("/create")
    public ResponseEntity<Object> AddRecipe(@RequestBody @Valid RecipeViewModel recipe){

        boolean result = _recipeApiService.CreateRecipe(recipe);

        return this.GenerateNoContentResponse(result);
    }

    @PutMapping("recipes/{recipeId}")
    public ResponseEntity<Object> UpdateRecipe(@PathVariable("recipeId") Long ID, @RequestBody RecipeViewModel recipe){

        boolean result = _recipeApiService.UpdateRecipe(ID, recipe);

        return this.GenerateNoContentResponse(result);
    }

    @DeleteMapping("recipes/{recipeId}")
    public ResponseEntity<Object> DeleteRecipe(@PathVariable("recipeId") Long ID){

        boolean result = _recipeApiService.DeleteRecipe(0L, ID);

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
