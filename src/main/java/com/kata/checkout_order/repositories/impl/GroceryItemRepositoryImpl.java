package com.kata.checkout_order.repositories.impl;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;

/**
 * Mock class of the grocery item repository, just stores the entities in memory
 */
@NoArgsConstructor
public class GroceryItemRepositoryImpl implements GroceryItemRepository {
    private float runningTotal = 0.0F;
    private List<GroceryItem> items = new ArrayList<>();
    private List<GroceryItem> availableGroceryItems = new ArrayList<>(AVAILABLE_GROCERY_ITEMS);

    public float addScannedItem(String itemName, int amount) {
        return runningTotal;
    }

    public float addScannedWeightedItem(String itemName, float weight) {
        return runningTotal;
    }

    public float addItemSpecial(GroceryItemSpecial itemSpecial) {
        return runningTotal;
    }

    public float removeScannedItem(String itemName) {
        return runningTotal;
    }

    public float getRunningTotal() {
        return runningTotal;
    }

    public List<GroceryItem> getItems() {
        return items;
    }

    public List<GroceryItem> getAvailableGroceryItems() {
        return availableGroceryItems;
    }
}
