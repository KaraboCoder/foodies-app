package com.foodies.foodies.Classes;

public class ShoppingListItem {
    public String ingredientName;
    public float quantity;
    public String unit;

    public ShoppingListItem(String name, float value, String units) {
        this.ingredientName = name;
        this.quantity = value;
        this.unit = units;
    }
}
