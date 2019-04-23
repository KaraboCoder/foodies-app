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
    private String displayPicture;
    private String timeToPrepare;
    private RecipeDifficulties difficultyLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<RecipeCategory> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
}
