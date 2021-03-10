package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;

import java.util.List;

public interface GroceryItemRepository {
    public float addScannedItem(String itemName, int amount);

    public float addScannedWeightedItem(String itemName, float weight);

    public float addItemSpecial(GroceryItemSpecial itemSpecial);

    public float removeScannedItem(String itemName);

    public float getRunningTotal();

    public List<GroceryItem> getItems();

    public List<GroceryItem> getAvailableGroceryItems();
}
