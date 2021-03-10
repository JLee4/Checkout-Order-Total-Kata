package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import org.junit.jupiter.api.Test;

public class GroceryItemRepositoryTest {
    // adding a scanned grocery item
    @Test
    public void addScannedItem_NoDiscount_Updates() {
    }

    @Test
    public void addScannedWeightedItem_NoDiscount_Updates() {
    }

    @Test
    public void addScannedItem_BeforeAddingDiscount_Updates() {
        // As in, a special is added after the item is scanned, the special should update the total price
    }

    @Test
    public void addScannedWeightedItem_BeforeAddingDiscount_Updates() {
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
