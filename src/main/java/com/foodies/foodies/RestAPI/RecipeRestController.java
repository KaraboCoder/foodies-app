package com.foodies.foodies.RestAPI;

import com.foodies.foodies.ViewModels.RecipeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class RecipeRestController {
    @Autowired
    private IRecipe _recipeService;

    @GetMapping("/recipes")
    private ResponseEntity<List<RecipeViewModel>> GetAll(){

        return new ResponseEntity(_recipeService.FetchAllRecipes(), HttpStatus.OK);
    }
}
