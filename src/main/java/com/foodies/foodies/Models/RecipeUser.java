package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "recipe_user")
public class RecipeUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeUserId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", nullable = false)
    @NotNull(message = "Recipe ID is required.")
    private Recipes recipe;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @NotNull(message = "User ID is required.")
    private Users user;

    protected RecipeUser() {}
}
