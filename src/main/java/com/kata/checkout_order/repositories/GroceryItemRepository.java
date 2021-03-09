package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock class of the grocery item repository, just stores the entities in memory
 */
public class GroceryItemRepository {
    private static double runningTotal = 0D;
    private static List<GroceryItem> items = new ArrayList<>();

    // TODO
}
