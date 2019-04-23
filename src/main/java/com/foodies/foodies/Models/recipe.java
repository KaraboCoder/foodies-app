package com.foodies.foodies.Models;

import com.foodies.foodies.constants.RecipeDifficulties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    @NotNull
    @Column(unique = true)
    private String title;
    private String description;

    @NotNull
    private String instructions;
    private String displayPicture;
    private String timeToPrepare;
    private RecipeDifficulties difficultyLevel;
    private Set<RecipeCategory> categories = new HashSet<>();
    private Set<Ingredient> ingredients = new HashSet<>();
}
