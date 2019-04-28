package com.foodies.foodies.Controllers;

import com.foodies.foodies.Models.Recipes;
import com.foodies.foodies.Services.contracts.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
}
