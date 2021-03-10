package com.kata.checkout_order.constants;

import com.kata.checkout_order.entities.GroceryItem;

import java.util.Arrays;
import java.util.List;

public class GroceryItemConstants {
    // simulating the list of available grocery items
    public static final List<GroceryItem> AVAILABLE_GROCERY_ITEMS = Arrays.asList(
            new GroceryItem("Ground Beef",3.99F, true),
            new GroceryItem("Ground Turkey",4.99F, true),
            new GroceryItem("New York Strip Steak",14.99F, true),
            new GroceryItem("Bananas",0.49F, true),
            new GroceryItem("Spinach",1.99F, true),
            new GroceryItem("Broccoli",1.99F, true),
            new GroceryItem("Russet Potatoes",0.99F, true),
            new GroceryItem("Hass Avocado",1.69F, false),
            new GroceryItem("Organic Tomatoes, 8 ounce",3.99F, false),
            new GroceryItem("Frozen French Fries",3.49F, false),
            new GroceryItem("Frozen Corn",2.19F, false),
            new GroceryItem("Large Eggs, dozen",1.99F, false),
            new GroceryItem("Can of Clam Chowder",1.49F, false),
            new GroceryItem("Can of Tomato Soup",0.89F, false),
            new GroceryItem("Bar Soap, 6 count",4.39F, false),
            new GroceryItem("Shampoo, 12 ounce",7.99F, false),
            new GroceryItem("Spaghetti, 16 ounce",1.39F, false),
            new GroceryItem("Multivitamins, 120 ct.",9.99F, false),
            new GroceryItem("Dry Dog Food, 4 lb.",10.99F, false),
            new GroceryItem("Baguette",2.75F, false)
        );
}