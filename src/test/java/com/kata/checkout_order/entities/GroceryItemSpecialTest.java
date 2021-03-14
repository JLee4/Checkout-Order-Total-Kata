package com.kata.checkout_order.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroceryItemSpecialTest {
    @Test
    public void newGroceryItemSpecial_NoItemName_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial(null, 0, 0, 0, 0, 0));
    }

    @Test
    public void newGroceryItemSpecial_NoDiscount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial("a", 0, 0, 0, 0, 0));
    }

    @Test
    public void newGroceryItemSpecial_NoDiscountAsSet_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial("a", 0, 0, 1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial("a", 0, 0, 0, 0, 1));

    }

    @Test
    public void newGroceryItemSpecial_OnlyItemNameAndDiscountedAmount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial("a", 0, 0, 0, 1, 0));
    }

    @Test
    public void newGroceryItemSpecial_LimitLessThanRequiredAmount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new GroceryItemSpecial("a", 0, 1, 2, 0, 0));
    }
}
