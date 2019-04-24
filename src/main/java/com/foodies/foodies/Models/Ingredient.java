package com.foodies.foodies.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @OneToOne
    private ShoppingListItem shoppingItem;

    @NotNull
    private String UnitOfMeasurement;

    @NotNull
    private int Quantity;
    private String MoreInfo;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes = new HashSet<>();

    //# region getters & setters

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public ShoppingListItem getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(ShoppingListItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public String getUnitOfMeasurement() {
        return UnitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        UnitOfMeasurement = unitOfMeasurement;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getMoreInfo() {
        return MoreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        MoreInfo = moreInfo;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    //# endregion
}
