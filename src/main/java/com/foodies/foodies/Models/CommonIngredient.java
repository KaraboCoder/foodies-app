package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Data
public class CommonIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;

    @Column(unique = true)
    @NotBlank(message = "Ingredient name is required.")
    private String ingredientName;


    public CommonIngredient() {}

    public CommonIngredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
