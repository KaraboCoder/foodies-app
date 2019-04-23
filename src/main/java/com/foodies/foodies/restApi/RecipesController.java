package com.foodies.foodies.restApi;

import com.foodies.foodies.DAO.UserProfilesRepository;
import com.foodies.foodies.Models.Recipe;
import com.foodies.foodies.Models.UserProfile;
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
    private UserProfilesRepository _users;

    @Autowired
    public RecipesController(IRecipesService recipeService) {
        this._recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> RetriveAllRecipes(){

        List<Recipe> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }


    @GetMapping("all/{id}")
    public ResponseEntity<Recipe> RetriveRecipeByID(@PathVariable("id") Long ID){

        Recipe result = _recipeService.FindRecipeByID(ID).orElse(null);

        return result != null?  new ResponseEntity(result, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }








//    Todo: Remove after testing!!
    @GetMapping("/users")
    public ResponseEntity<List<UserProfile>> RetriveAllUsers(){

        List<UserProfile> results = new ArrayList<>();

        _users.findAll().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }

    @PostMapping("user/create")
    public  String SaveUserProfile(@RequestBody UserProfile usr){
        try{
            _users.save(usr);
            return "Result: " + HttpStatus.OK;
        }catch (Exception e){
            return "Error: " + e;
        }



    }


}
