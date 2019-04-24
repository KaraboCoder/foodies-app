package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Recipe ID is required.")
    private Long recipeId;

    @NotNull(message = "Category ID is required.")
    private Long categoryId;

    protected RecipeCategory() {}

    private RecipeCategory(Long recipeId, Long categoryId) {
        this.recipeId = recipeId;
        this.categoryId = categoryId;
    }
}
