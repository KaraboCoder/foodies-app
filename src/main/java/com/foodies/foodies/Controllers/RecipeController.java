package com.foodies.foodies.Controllers;

import com.foodies.foodies.Services.contracts.IRecipeService;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

        List<RecipeViewModel> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));

        model.addAttribute("recipeList", results);

        return "recipes/browse";
    }

    @GetMapping("recipes/{recipeId}")
    public String GetRecipeDetails(@PathVariable("recipeId") Long ID, Model model){

        RecipeViewModel recipe = _recipeService.FindRecipeByID(ID);

        // TODO: Create /error page if not found
        model.addAttribute("recipe", recipe);
        return "recipes/detail-view";
    }

    @GetMapping("/recipes/create")
    public String ShowRecipeCreateForm(Model model) {

        model.addAttribute("recipe", new RecipeViewModel());
        ArrayList<String> Ingredients = new ArrayList<>();
        ArrayList<String> Units = new ArrayList<>();
        ArrayList<String> Categories = new ArrayList<>();

        Ingredients.add("Eggs");
        Ingredients.add("Beef");
        Ingredients.add("Chicken");
        Ingredients.add("Carrots");

        Units.add("KG");
        Units.add("Litre");
        Units.add("Grams");

        Categories.add("Dessert");
        Categories.add("Dinner");
        Categories.add("Breakfast");

        model.addAttribute(("Ingredients"), Ingredients);
        model.addAttribute(("Units"), Units);
        model.addAttribute(("Categories"), Categories);


        return "recipes/create";
    }

    @PostMapping("/recipes/save")
    public String SaveNewRecipe(@Valid RecipeViewModel recipe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/recipes/create";
        }

        boolean isCreated = _recipeService.CreateRecipe(recipe);

        return isCreated? "redirect:/recipes/browse" :  "redirect:/recipes/create";
    }

    @PostMapping(value="/recipes/save", params={"addRow"})
    public String addRow(@Valid RecipeViewModel recipe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/recipes/create";
        }

        boolean isCreated = _recipeService.CreateRecipe(recipe);

        return isCreated? "redirect:/recipes/browse" :  "redirect:/recipes/create";
    }


    @GetMapping("/recipes/shopping")
    public String ShowShoppingList(Model model) {
        return "recipes/shopping-list";
    }

    @PostMapping("/recipes/update/{id}")
    public String UpdateRecipe(@Valid RecipeViewModel recipe, @PathVariable("id") Long ID){

        boolean isUpdated = _recipeService.UpdateRecipe(ID, recipe);

        return isUpdated? "redirect:/recipes/browse" :  "redirect:/recipes/" + ID;
    }

    @GetMapping("recipes/delete/{recipeId}")
    public String DeleteRecipe(@PathVariable("recipeId") Long ID, Model model){

        RecipeViewModel recipe = _recipeService.FindRecipeByID(ID);
        if(recipe == null) return "error";
        boolean result = _recipeService.DeleteRecipe(0L, ID);
        model.addAttribute("isDeleted", result);
        model.addAttribute("recipe", recipe);

        return "recipes/action-confirm";
    }

    @GetMapping("recipes/view/{recipeId}")
    public String ViewRecipe(@PathVariable("recipeId") Long ID, Model model){
        System.out.println("I got called");
        RecipeViewModel recipe = _recipeService.FindRecipeByID(ID);

        // TODO: Create /error page if not found
        model.addAttribute("recipe", recipe);
        return "recipes/view-recipe";
    }
}
