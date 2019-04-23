package com.foodies.foodies.Models;

import com.foodies.foodies.constants.RecipeDifficulties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    @NotNull
    @Column(unique = true)
    private String title;
    @Column(name = "OwnerId")
    private Long owner = 0L;
    private String description;

    @NotNull
    private String instructions;
    private String displayPictureUrl;
    private String timeToPrepare;
    private RecipeDifficulties difficultyLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<RecipeCategory> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();


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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDisplayPicture() {
        return displayPictureUrl;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPictureUrl = displayPicture;
    }

    public String getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(String timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public RecipeDifficulties getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(RecipeDifficulties difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
