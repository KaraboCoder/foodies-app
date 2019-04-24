package com.foodies.foodies.Models;

import com.foodies.foodies.constants.RecipeDifficulties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    @NotNull
    @Column(unique = true)
    private String title;
    @Column(name = "owner_id")
    private Long owner = 0L;
    private String description;

    @NotNull
    private String instructions;
    private String display_pic_url;
    private String time_to_prepare;
    private String  difficulty_level;

    @NonNull
    @OneToOne
    private Category category = new Category();

    @NotNull
    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<>();

   //# region getters & setters


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

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

    //# endregion


    public String toString()
    {
        return id + " " + title + " "  + " " + instructions + " ";
    }
}
