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

@Data
@Entity
@Table(name = "ingredients")
public class Ingredients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Ingredient name is required.")
    private String ingredientName;

    @NotNull
    private String units;

    @NotNull
    private float amount;

    public Ingredients() {}

    Ingredients(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
