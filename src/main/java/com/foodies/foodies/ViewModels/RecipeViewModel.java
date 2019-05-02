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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_pic_url() {
        return display_pic_url;
    }

    public void setDisplay_pic_url(String display_pic_url) {
        this.display_pic_url = display_pic_url;
    }

    public String getTime_to_prepare() {
        return time_to_prepare;
    }

    public void setTime_to_prepare(String time_to_prepare) {
        this.time_to_prepare = time_to_prepare;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public RecipeCategoryDao getCategory() {
        return category;
    }

    public void setCategory(RecipeCategoryDao category) {
        this.category = category;
    }

    public List<InstructionDao> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionDao> instructions) {
        this.instructions = instructions;
    }

    public List<IngredientDao> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDao> ingredients) {
        this.ingredients = ingredients;
    }
}
