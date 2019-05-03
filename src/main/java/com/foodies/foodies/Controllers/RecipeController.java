package com.foodies.foodies.Controllers;

import com.foodies.foodies.Classes.ShoppingListItem;
import com.foodies.foodies.Entities.RecipeCategoryDao;
import com.foodies.foodies.Models.CommonIngredient;
import com.foodies.foodies.Models.Units;
import com.foodies.foodies.Repositories.CommonIngredientRepository;
import com.foodies.foodies.Repositories.IngredientDaoRepository;
import com.foodies.foodies.Repositories.RecipeCategoryDaoRepository;
import com.foodies.foodies.Repositories.UnitsRepository;
import com.foodies.foodies.Services.contracts.IPreloadedFieldsService;
import com.foodies.foodies.Services.contracts.IRecipeService;
import com.foodies.foodies.ViewModels.RecipeViewModel;
import lombok.ToString;
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
    private IPreloadedFieldsService _preloadedService;


    public  RecipeController(){}

    @Autowired
    public RecipeController(IRecipeService recipeService,
                            IPreloadedFieldsService preloadedVals) {
        this._recipeService = recipeService;
        this._preloadedService = preloadedVals;
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
        var preloaded = _preloadedService.FetchAll();
        RecipeViewModel recipe = _recipeService.FindRecipeByID(ID);

        // TODO: Create /error page if not found
        model.addAttribute("recipe", recipe);
        model.addAttribute(("Ingredients"), preloaded.getIngredients());
        model.addAttribute(("Units"), preloaded.getUnits());
        model.addAttribute(("Categories"), preloaded.getCategories());

        return "recipes/detail-view";
    }

    @GetMapping("/recipes/create")
    public String ShowRecipeCreateForm(Model model) {
        var preloaded = _preloadedService.FetchAll();

        model.addAttribute("recipe", new RecipeViewModel());
        model.addAttribute(("Ingredients"), preloaded.getIngredients());
        model.addAttribute(("Units"), preloaded.getUnits());
        model.addAttribute(("Categories"), preloaded.getCategories());

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
        List<RecipeViewModel> results = new ArrayList<>();

        _recipeService.FetchAllRecipes().forEach(item -> results.add((item)));


        ArrayList<ShoppingListItem> shoppingList = new ArrayList<>();

        results.forEach(recipeViewModel -> {
            recipeViewModel.ingredients.forEach(ingredientDao -> {
                String currentIngredientName = ingredientDao.getName();
                float quantity = ingredientDao.getQuantity();
                String unit_measurement = ingredientDao.getUnit_of_measurement();
                int nameResult = alreadyInList(shoppingList, currentIngredientName);
                if (nameResult == -1) {
                    ShoppingListItem item = new ShoppingListItem(currentIngredientName,quantity, unit_measurement);
                    shoppingList.add(item);
                } else {
                    shoppingList.get(nameResult).quantity =  shoppingList.get(nameResult).quantity + quantity;
                }
            });
        });
        model.addAttribute("shoppingListItems", shoppingList);
        return "recipes/shopping-list";
    }

    public int alreadyInList(ArrayList<ShoppingListItem> shoppingListNames, String ingredientName) {
        int length = shoppingListNames.size();
        int alreadyExists = -1;
        for (int i = 0; i < length; i++) {
            String itemName = shoppingListNames.get(i).ingredientName;
            if( itemName.equals(ingredientName)) {
                System.out.println("Already Exists");
                alreadyExists = i;
                break;
            }
        }
        return alreadyExists;
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


