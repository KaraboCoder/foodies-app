package com.foodies.foodies.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shopping_list_item")
public class ShoppingListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long ID;

    @NotNull
    private  String Name;
    private float EstimatedPrice;

    public ShoppingListItem(@NotNull String name, float estimatedPrice) {
        Name = name;
        EstimatedPrice = estimatedPrice;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getEstimatedPrice() {
        return EstimatedPrice;
    }

    public void setEstimatedPrice(float estimatedPrice) {
        EstimatedPrice = estimatedPrice;
    }
}
