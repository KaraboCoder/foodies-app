package com.foodies.foodies.ViewModels;

import com.foodies.foodies.Entities.IngredientDao;
import com.foodies.foodies.Entities.InstructionDao;
import com.foodies.foodies.Entities.RecipeCategoryDao;;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RecipeViewModel {
    public  long id;
    @NotNull
    public String title;
    public String description;
    public String display_pic_url;
    public String time_to_prepare;
    public String difficulty_level;

    @NotNull
    public RecipeCategoryDao category;

    @NotNull
    public List<InstructionDao> instructions;

    @NotNull
    public List<IngredientDao> ingredients;


}
