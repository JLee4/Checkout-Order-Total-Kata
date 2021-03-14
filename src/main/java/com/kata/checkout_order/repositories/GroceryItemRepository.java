package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;

import java.util.Collection;

public interface GroceryItemRepository {
    float addScannedItem(String itemName, float amountAdded);

    boolean addItemSpecial(GroceryItemSpecial itemSpecial);

    float removeScannedItem(String itemName, float amountRemoved);

    float getRunningTotal();

    Collection<GroceryItem> getItems();

    Collection<GroceryItem> getAvailableGroceryItems();
}
