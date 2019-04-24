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
public class Instructions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Cooking instruction is required.")
    private String CookingInstruction;

    @NotNull(message = "Recipe ID is required.")
    private Long recipeId;

    protected Instructions() {}

    private Instructions(String CookingInstruction, Long recipeId) {
        this.CookingInstruction = CookingInstruction;
        this.recipeId = recipeId;
    }
}
