package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingItemRepository extends CrudRepository<ShoppingListItem, Long> {
}
