package com.foodies.foodies.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeDao {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    @NotNull
    @Column(unique=true)
    private String title;

    private Long owner = 0L;
    private String description;
    private String display_pic_url;
    private String time_to_prepare;
    private String  difficulty_level;

    @NotNull
    @OneToOne
    private RecipeCategoryDao category = new RecipeCategoryDao();

    @NotNull
    @OneToMany
    private List<InstructionDao> instructions = new ArrayList<>();

    @NotNull
    @OneToMany
    private List<IngredientDao> ingredients = new ArrayList<>();

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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
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
