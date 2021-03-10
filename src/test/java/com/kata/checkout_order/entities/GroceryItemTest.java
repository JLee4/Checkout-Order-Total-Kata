package com.kata.checkout_order.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroceryItemTest {
    @Test
    public void testFractionalAmountWhenItemNotWeighted() {
        GroceryItem mockGroceryItem = new GroceryItem("test", 0.0F, false);
        assertThrows(IllegalArgumentException.class, () -> mockGroceryItem.setAmount(0.5F));
    }
}
