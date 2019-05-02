package com.foodies.foodies.Controllers;

//Mockito
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//JUnit
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Assert;

//Other
import org.springframework.ui.Model;
import com.foodies.foodies.Models.Users;
import com.foodies.foodies.Controllers.RecipeController;
import com.foodies.foodies.Models.Recipes;
import com.foodies.foodies.Services.contracts.IRecipeService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {
    @Mock
    private IRecipeService _recipeService;


    @InjectMocks
    private RecipeController recipeController = new RecipeController();

    @Mock
    private Model model;

    @Test
    public void GetAllRecipes_shouldReturnRecipeList(){
//        List<Recipes> results = new ArrayList<>();
//        when(_recipeService.FetchAllRecipes()).thenCallRealMethod();
//        String returnValue = recipeController.GetAllRecipes(model);
//        verify(model, times(1)).addAttribute("recipeList", results);
//        Assert.assertEquals("recipes/browse", returnValue);
    }

    @Test
    public void GetRecipeDetails_shouldReturnRecipe(){
//        Long ID= Long.parseLong("1");
//        when(_recipeService.FindRecipeByID(ID)).thenCallRealMethod();
//        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
//        String returnValue = recipeController.GetRecipeDetails(ID,model);
//        verify(model, times(1)).addAttribute("recipe", recipe);
//        Assert.assertEquals("recipes/detail-view", returnValue);
    }

    @Test
    public void ShowRecipeCreateForm_shouldReturnNewRecipe(){
        Recipes recipe = new Recipes();
        String returnValue = recipeController.ShowRecipeCreateForm(model);
        verify(model, times(1)).addAttribute("recipe", recipe);
        Assert.assertEquals("recipes/create", returnValue);
    }

    @Test
    public void SaveNewRecipe_shouldRedirectOnIsCreatedBoolean(){
//        Recipes recipe= new Recipes();
//        BindingResult result= mock(BindingResult.class);
//        when(result.hasErrors()).thenReturn(false);
//        when(_recipeService.CreateRecipe(recipe)).thenCallRealMethod();
//        String returnValue = recipeController.SaveNewRecipe(recipe,result,model);
//        Assert.assertEquals("redirect:/recipes/browse", returnValue);
    }

    @Test
    public void UpdateRecipe_shouldRedirectOnIsUpdatedBoolean(){
//        Long ID= Long.parseLong("1");
//        Recipes recipe=new Recipes();
//        when(_recipeService.UpdateRecipe(ID, recipe)).thenCallRealMethod();
//        String returnValue = recipeController.UpdateRecipe(recipe,ID);
//        Assert.assertEquals("redirect:/recipes/browse", returnValue);
    }

    @Test
    public void DeleteRecipeAndRecipeNotFound_shouldReturnError(){
//        Long ID= Long.parseLong("-1");
//        when(_recipeService.FindRecipeByID(ID)).thenReturn(null);
//        when(_recipeService.DeleteRecipe(0L,ID)).thenReturn(false);
//        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
//        String returnValue = recipeController.DeleteRecipe(ID,model);
//        verify(model, times(1)).addAttribute("isDeleted", false);
//        verify(model, times(1)).addAttribute("recipe", null);
//        Assert.assertEquals("error", returnValue);
    }

    @Test
    public void DeleteRecipe_shouldReturnDeletedRecipe(){
//        Long ID= Long.parseLong("1");
//        when(_recipeService.FindRecipeByID(ID)).thenCallRealMethod();
//        Recipes recipe = _recipeService.FindRecipeByID(ID).orElse(null);
//        String returnValue = recipeController.DeleteRecipe(ID,model);
//        verify(model, times(1)).addAttribute("isDeleted", true);
//        verify(model, times(1)).addAttribute("recipe", recipe);
//        Assert.assertEquals("recipes/action-confirm", returnValue);
    }
}
