package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.repositories.impl.GroceryItemRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryItemRepositoryTest {
    private GroceryItemRepository mockGroceryItemRepository;
    private final int nonWeightedItemIndex = 10;
    private final int weightedItemIndex = 0;

    @BeforeEach
    void setUp() {
        mockGroceryItemRepository = new GroceryItemRepositoryImpl();
    }

    // adding a scanned grocery item
    @Test
    public void addScannedItem_NoDiscount_Updates() {
        GroceryItem mockItem = AVAILABLE_GROCERY_ITEMS.get(this.nonWeightedItemIndex);
        assertEquals(mockItem.getPrice(), mockGroceryItemRepository.addScannedItem(mockItem.getName(), 1));
        assertEquals((mockItem.getPrice() * 2), mockGroceryItemRepository.addScannedItem(mockItem.getName(), 1));
    }

    @Test
    public void addScannedWeightedItem_NoDiscount_Updates() {
        GroceryItem mockItem = AVAILABLE_GROCERY_ITEMS.get(this.weightedItemIndex);
        float weight = 0.5F;
        assertEquals(mockItem.getPrice() * weight, mockGroceryItemRepository.addScannedItem(mockItem.getName(), weight));
    }

    @Test
    public void addScannedItem_AfterAddingDiscount_Updates() {
        // As in, a special is added after the item is scanned, the special should update the total price
    }

    @Test
    public void addScannedWeightedItem_AfterAddingDiscount_Updates() {
        // As in, a special is added after the item is scanned, the special should update the total price
    }

    @Test
    public void addScannedItem_DiscountedItemLimit_UpdatesWithoutDiscount() {
        // can scan more items over the limit but special would not apply
    }

    @Test
    public void addScannedWeightedItem_DiscountedItemLimit_UpdatesWithoutDiscount() {
        // can scan more items over the limit but special would not apply
    }

    // adding a grocery item special
    @Test
    public void addItemSpecial_AllItemsDiscount_Updates() {
    }

    @Test
    public void addWeightedItemSpecial_AllItemsDiscount_Updates() {
    }

    @Test
    public void addItemSpecial_RequiredAmount_Updates() {
    }

    @Test
    public void addWeightedItemSpecial_RequiredAmount_Updates() {
    }

    @Test
    public void addItemSpecial_RequiredAmountFreeItemDiscount_Updates() {
    }

    @Test
    public void addWeightedItemSpecial_RequiredAmountFreeItemDiscount_Updates() {
    }

    @Test
    public void addItemSpecial_DiscountedItemLimit_Updates() {
    }

    @Test
    public void addWeightedItemSpecial_DiscountedItemLimit_Updates() {
    }

    @Test
    public void addItemSpecial_DiscountedAsASet_Updates() {
    }

    @Test
    public void addWeightedItemSpecial_DiscountedAsASet_Updates() {
    }

    // removing a scanned item
    @Test
    public void removeScannedItem_NoDiscount_Updates() {
    }

    @Test
    public void removeScannedWeightedItem_NoDiscount_Updates() {
    }

    @Test
    public void removeScannedItem_WithAppliedDiscount_UpdatesWithoutDiscount() {
    }

    @Test
    public void removeScannedWeightedItem_WithAppliedDiscount_UpdatesWithoutDiscount() {
    }
}
