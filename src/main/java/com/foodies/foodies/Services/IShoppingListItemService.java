package com.foodies.foodies.Services;

import com.foodies.foodies.Models.ShoppingListItem;

import java.util.Optional;

public interface IShoppingListItemService {

    Iterable<ShoppingListItem> FetchAllItems();
    Optional<ShoppingListItem> FindItemByID(Long ID);

    boolean CreateShoppingListItem(ShoppingListItem item);
    boolean UpdateShoppingListItem(Long ID, ShoppingListItem updated);
    boolean DeleteShoppingListItem(Long ID);
}
