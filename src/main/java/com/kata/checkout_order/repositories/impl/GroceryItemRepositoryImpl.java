package com.kata.checkout_order.repositories.impl;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.GroceryItemRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;

/**
 * Mock class of the grocery item repository, just stores the entities in memory
 */
public class GroceryItemRepositoryImpl implements GroceryItemRepository {
    private float runningTotal = 0.0F;
    private final Map<String, GroceryItem> items = new HashMap<>();
    private final Map<String, GroceryItem> availableGroceryItems = new HashMap<>();

    public GroceryItemRepositoryImpl() {
        for (GroceryItem currItem : AVAILABLE_GROCERY_ITEMS) {
            availableGroceryItems.put(currItem.getName(), currItem);
        }
    }

    public float addScannedItem(String itemName, float amount) {
        items.putIfAbsent(itemName, availableGroceryItems.get(itemName));
        GroceryItem item = items.get(itemName);
        item.setAmount(item.getAmount() + amount);
        runningTotal += (amount * item.getPrice());
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

    public Collection<GroceryItem> getItems() {
        return items.values();
    }

    public Collection<GroceryItem> getAvailableGroceryItems() {
        return availableGroceryItems.values();
    }
}
