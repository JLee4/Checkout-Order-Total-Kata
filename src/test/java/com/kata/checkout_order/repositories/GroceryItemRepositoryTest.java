package com.kata.checkout_order.repositories;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.impl.GroceryItemRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryItemRepositoryTest {
    private GroceryItemRepository mockGroceryItemRepository;
    private final GroceryItem mockNonWeightedItem = AVAILABLE_GROCERY_ITEMS.get(10);
    private final GroceryItem mockWeightedItem = AVAILABLE_GROCERY_ITEMS.get(0);

    @BeforeEach
    void setUp() {
        mockGroceryItemRepository = new GroceryItemRepositoryImpl();
        // resetting the objects, deep copy is an alternative but don't want to import another third-party library
        mockWeightedItem.setAmount(0);
        mockWeightedItem.setCurrentItemTotal(0);
        mockWeightedItem.setSpecial(null);
        mockNonWeightedItem.setAmount(0);
        mockNonWeightedItem.setCurrentItemTotal(0);
        mockNonWeightedItem.setSpecial(null);
    }

    // adding a scanned grocery item
    @Test
    public void addScannedItem_NoDiscount_Updates() {
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 1));
        assertEquals((mockNonWeightedItem.getPrice() * 2),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 1));
    }

    @Test
    public void addScannedWeightedItem_NoDiscount_Updates() {
        float weight = 0.5F;
        assertEquals(mockWeightedItem.getPrice() * weight,
                mockGroceryItemRepository.addScannedItem(mockWeightedItem.getName(), weight));
    }

    @Test
    public void addScannedItem_BeforeAddingDiscount_UpdatesWithDiscount() {
        // As in, a special is added after the item is scanned, the special should update the total price
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 1));

        float discount = 0.2F; // 20% off
        float scannedAmount = 3;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, 0, 0, 0, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals((1.0F - discount) * mockNonWeightedItem.getPrice() * (scannedAmount + 1),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 3));
    }

    @Test
    public void addScannedWeightedItem_BeforeAddingDiscount_UpdatesWithDiscount() {
        // As in, a special is added after the item is scanned, the special should update the total price
        assertEquals(mockWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockWeightedItem.getName(), 1));

        float discount = 0.5F; // 50% off
        float scannedAmount = 3.5F;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockWeightedItem.getName(), discount, 0, 0, 0, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);

        float expectedRunningTotal = (discount * mockWeightedItem.getPrice() * (scannedAmount + 1));
        assertEquals(expectedRunningTotal,
                mockGroceryItemRepository.addScannedItem(mockWeightedItem.getName(), scannedAmount));
    }

    // adding a grocery item special
    @Test
    public void addItemSpecial_AllItemsDiscount_Updates() {
        float discount = 0.2F; // 20% off
        float scannedAmount = 3;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, 0, 0, 0, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(((1.0F - discount) * mockNonWeightedItem.getPrice() * scannedAmount),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 3));
    }

    @Test
    public void addItemSpecial_RequiredAmount_Updates() {
        float discount = 0.5F; // 50% off
        float scannedAmount = 3;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, 0, 2, 1, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);

        float expectedRunningTotal = (discount * mockNonWeightedItem.getPrice()) + (2 * mockNonWeightedItem.getPrice());
        assertEquals(expectedRunningTotal,
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 3));
    }

    @Test
    public void addWeightedItemSpecial_RequiredAmount_Updates() {
        float discount = 0.5F; // 50% off
        float scannedAmount = 3.5F;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockWeightedItem.getName(), discount, 0, 2, 1.5F, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);

        float expectedRunningTotal = (discount * 1.5F * mockWeightedItem.getPrice()) + (2 * mockWeightedItem.getPrice());
        assertEquals(expectedRunningTotal,
                mockGroceryItemRepository.addScannedItem(mockWeightedItem.getName(), scannedAmount));
    }

    @Test
    public void addItemSpecial_RequiredAmountNotEnough_UpdatesWithoutSpecialApplied() {
        float discount = 0.5F; // 50% off
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, 0, 2, 1, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 1));
    }

    @Test
    public void addItemSpecial_RequiredAmountFreeItemDiscount_Updates() {
        float discount = 1.0F; // 100% off
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, 0, 1, 1, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 2));
    }

    @Test
    public void addItemSpecial_DiscountedItemLimit_Updates() {
        float discount = 0.2F; // 20% off
        float limit = 2;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), discount, limit, 0, 0, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);

        float expectedRunningTotal = ((1.0F - discount) * mockNonWeightedItem.getPrice() * limit) + mockNonWeightedItem.getPrice();
        assertEquals(expectedRunningTotal,
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 3));
    }

    @Test
    public void addItemSpecial_DiscountedAsASet_Updates() {
        float discountedSetAmount = 5.0F;
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), 0.0F, 0, 3, 0, discountedSetAmount);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(discountedSetAmount,
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 3));
    }

    @Test
    public void addItemSpecial_DiscountedAsASetNotEnough_UpdatesWithoutSpecialApplied() {
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), 0.0F, 0, 2, 0, 2.99F);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 1));
    }

    // removing a scanned item
    @Test
    public void removeScannedItem_NoDiscount_Updates() {
        assertEquals(mockNonWeightedItem.getPrice() * 2,
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 2));
        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.removeScannedItem(mockNonWeightedItem.getName(), 1));
    }

    @Test
    public void removeScannedWeightedItem_NoDiscount_Updates() {
        assertEquals(mockWeightedItem.getPrice() * 1.5F,
                mockGroceryItemRepository.addScannedItem(mockWeightedItem.getName(), 1.5F));
        assertEquals(mockWeightedItem.getPrice(),
                mockGroceryItemRepository.removeScannedItem(mockWeightedItem.getName(), 0.5F));
    }

    @Test
    public void removeScannedItem_WithAppliedDiscount_UpdatesWithoutDiscount() {
        GroceryItemSpecial mockItemSpecial =
                new GroceryItemSpecial(mockNonWeightedItem.getName(), 0.5F, 0, 2, 0, 0);
        mockGroceryItemRepository.addItemSpecial(mockItemSpecial);
        assertEquals(mockNonWeightedItem.getPrice() * 2 * mockItemSpecial.getDiscount(),
                mockGroceryItemRepository.addScannedItem(mockNonWeightedItem.getName(), 2));

        assertEquals(mockNonWeightedItem.getPrice(),
                mockGroceryItemRepository.removeScannedItem(mockNonWeightedItem.getName(), 1));
    }
}
