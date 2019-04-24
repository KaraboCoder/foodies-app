package com.foodies.foodies.Services.Definitions;

import com.foodies.foodies.DAO.ShoppingItemRepository;
import com.foodies.foodies.Models.ShoppingListItem;
import com.foodies.foodies.Services.IShoppingListItemService;
import com.foodies.foodies.helpers.FoodiesGenericHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShoppingListItemService implements IShoppingListItemService {

    private ShoppingItemRepository _itemsRepo;
    private Logger _logger = LoggerFactory.getLogger(ShoppingListItemService.class);

    @Autowired
    public ShoppingListItemService(Logger _logger, ShoppingItemRepository shopItem) {
        this._logger = _logger;
        this._itemsRepo = shopItem;
    }

    public Iterable<ShoppingListItem> FetchAllItems() {
        try {
            return _itemsRepo.findAll();
        } catch (Exception e) {
            _logger.error("Failed to retrieve shopping list items .Error details: " + e.getMessage());
            return null;
        }
    }

    public Optional<ShoppingListItem> FindItemByID(Long ID) {
        return _itemsRepo.findById(ID);
    }

    public boolean CreateShoppingListItem(ShoppingListItem item) {
        try {
            _itemsRepo.save(item);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to create shop item. Error details: " + e.getMessage());
            return false;
        }
    }

    public boolean UpdateShoppingListItem(Long ID, ShoppingListItem updated) {
        if( !_itemsRepo.existsById(ID)) return  false;

        try{
            var itemToUpdate = this.FindItemByID(ID).orElseThrow();

            if(FoodiesGenericHelpers.IsNullOrEmpty(updated.getName() ) ) itemToUpdate.setName(updated.getName());

            _itemsRepo.save(itemToUpdate);
            return  true;

        }catch (Exception e){
            _logger.error("Failed to update asset with Id: " + ID + ". Error details: " + e.getMessage());
            return  false;
        }
    }

    public boolean DeleteShoppingListItem(Long ID) {
        try {
            _itemsRepo.deleteById(ID);
            return true;
        } catch (Exception e) {
            _logger.error("Failed to delete shop item with ID: " + ID + ". Error details: " + e.getMessage());
            return false;
        }
    }
}
