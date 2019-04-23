package com.foodies.foodies.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @NotNull
    private String Name;

    @NotNull
    private String UnitOfMeasurement;

    @NotNull
    private float Quantity;
    private String MoreInfo;
    private int EstimatedPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private  Recipe recipe;
}
