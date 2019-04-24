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
public class RecipeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Recipe ID is required.")
    private Long recipeId;

    @NotNull(message = "User ID is required.")
    private Long userId;

    protected RecipeUser() {}

    private RecipeUser(Long recipeId, Long userId) {
        this.recipeId = recipeId;
        this.userId = userId;
    }
}
