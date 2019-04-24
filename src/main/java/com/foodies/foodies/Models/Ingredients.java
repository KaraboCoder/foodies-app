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
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Ingredient name is required.")
    private String ingredientName;

    private Long categoryId;

    protected Ingredients() {}

    public Ingredients(String ingredientName, Long categoryId) {
        this.ingredientName = ingredientName;
        this.categoryId = categoryId;
    }

}
