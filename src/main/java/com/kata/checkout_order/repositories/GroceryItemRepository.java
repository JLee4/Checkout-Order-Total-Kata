package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;

import java.util.ArrayList;
import java.util.List;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;

/**
 * Mock class of the grocery item repository, just stores the entities in memory
 */
public class GroceryItemRepository {
    private static double runningTotal = 0D;
    private static List<GroceryItem> items = new ArrayList<>();
    private static List<GroceryItem> availableGroceryItems = new ArrayList<>(AVAILABLE_GROCERY_ITEMS);

    // TODO
    public static double addScannedItem(String itemName) {
        return runningTotal;
    }

    public static double addScannedWeightedItem(String itemName) {
        return runningTotal;
    }

    public static double addItemSpecial(GroceryItemSpecial itemSpecial) {
        return runningTotal;
    }

    public static double removeScannedItem(String itemName) {
        return runningTotal;
    }
}
