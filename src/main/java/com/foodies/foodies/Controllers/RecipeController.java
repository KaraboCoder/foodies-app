package com.foodies.foodies.Controllers;

import com.foodies.foodies.Models.Recipes;
import com.foodies.foodies.Services.contracts.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/*
*   TODO: We need to use a view model in order
*    to capture all info required to generate a
*    useful recipe.
* */

@Controller
public class RecipeController {
    private IRecipeService _recipeService;

    @Autowired
    public RecipeController(IRecipeService _recipeService) {
        this._recipeService = _recipeService;
    }

    @GetMapping("recipes/browse")
    public String GetAllRecipes(Model model){

        List<Recipes> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));
        model.addAttribute("recipeList", results);

        return "recipes/browse";
    }

    @GetMapping("recipes/{recipeId}")
    public String GetRecipeDetails(@PathVariable("recipeId") Long ID, Model model){
        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
        model.addAttribute("recipe", recipe);
        return "recipes/detail-view";
    }

    @GetMapping("/recipes/create")
    public String ShowRecipeCreateForm(Model model) {
        model.addAttribute("recipe", new Recipes());
        ArrayList<String> Ingredients = new ArrayList<>();
        Ingredients.add("Eggs");
        Ingredients.add("Beef");
        Ingredients.add("Chicken");
        Ingredients.add("Carrots");
        model.addAttribute(("Ingredients"), Ingredients);
        return "recipes/create";
    }

    @PostMapping("/recipes/save")
    public String SaveNewRecipe(@Valid Recipes recipe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/recipes/create";
        }

        boolean isCreated = _recipeService.CreateRecipe(recipe);

        return isCreated? "redirect:/recipes/browse" :  "redirect:/recipes/create";
    }

    @PostMapping("/recipes/update/{id}")
    public String UpdateRecipe(@Valid Recipes recipe, @PathVariable("id") Long ID){
        boolean isUpdated = _recipeService.UpdateRecipe(ID, recipe);
        return isUpdated? "redirect:/recipes/browse" :  "redirect:/recipes/" + ID;
    }

    @GetMapping("recipes/delete/{recipeId}")
    public String DeleteRecipe(@PathVariable("recipeId") Long ID, Model model){
        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
        if(recipe == null) return "error";
        boolean result = _recipeService.DeleteRecipe(0L, ID);
        model.addAttribute("isDeleted", result);
        model.addAttribute("recipe", recipe);

        return "recipes/action-confirm";
    }

    @GetMapping("recipes/view/{recipeId}")
    public String ViewRecipe(@PathVariable("recipeId") Long ID, Model model){
        System.out.println("I got called");
//        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
//        if(recipe == null) return "error";
//
//        boolean result = _recipeService.DeleteRecipe(0L, ID);
//        model.addAttribute("isDeleted", result);
//        model.addAttribute("recipe", recipe);

        return "recipes/view-recipe";
    }
}
