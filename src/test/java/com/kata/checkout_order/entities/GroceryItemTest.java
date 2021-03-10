package com.kata.checkout_order.entities;

import org.junit.jupiter.api.Test;

public class GroceryItemTest {
    @Test
    public void testFractionalAmountWhenItemNotWeighted() {
        GroceryItem mockGroceryItem = new GroceryItem("test", 0.0F, false);
        mockGroceryItem.setAmount(0.5F);
    }
}
