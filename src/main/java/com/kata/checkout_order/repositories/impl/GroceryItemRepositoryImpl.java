package com.kata.checkout_order.repositories.impl;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;

/**
 * Mock class of the grocery item repository, just stores the entities in memory
 */
@Service
@Qualifier("groceryItemRepository")
public class GroceryItemRepositoryImpl implements GroceryItemRepository {
    private float runningTotal = 0.0F;
    private final Map<String, GroceryItem> items = new HashMap<>();
    private final Map<String, GroceryItem> availableGroceryItems = new HashMap<>();

    public GroceryItemRepositoryImpl() {
        for (GroceryItem currItem : AVAILABLE_GROCERY_ITEMS) {
            availableGroceryItems.put(currItem.getName(), currItem);
        }
    }

    public float addScannedItem(String itemName, float amountAdded) {
        items.putIfAbsent(itemName, availableGroceryItems.get(itemName));
        GroceryItem item = items.get(itemName);
        item.setAmount(item.getAmount() + amountAdded);
        return calculateItemTotal(item);
    }

    public void addItemSpecial(GroceryItemSpecial itemSpecial) {
        GroceryItem item = availableGroceryItems.get(itemSpecial.getItemName());
        item.setSpecial(itemSpecial);
        if (items.containsKey(itemSpecial.getItemName())) {
            runningTotal -= item.getCurrentItemTotal();
            item.setCurrentItemTotal(this.calculateDiscountedTotal(item));
            runningTotal += calculateDiscountedTotal(item);
        }
    }

    public float removeScannedItem(String itemName, float amountRemoved) {
        GroceryItem item = items.get(itemName);
        item.setAmount(item.getAmount() - amountRemoved);
        return calculateItemTotal(item);
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

    private float calculateItemTotal(GroceryItem item) {
        runningTotal -= item.getCurrentItemTotal();
        if (item.getSpecial() != null) {
            item.setCurrentItemTotal(this.calculateDiscountedTotal(item));
        } else {
            item.setCurrentItemTotal(item.getAmount() * item.getPrice());
        }
        runningTotal += item.getCurrentItemTotal();
        return runningTotal;
    }

    private float calculateDiscountedTotal(GroceryItem item) {
        GroceryItemSpecial itemSpecial = item.getSpecial();
        float discountedAmount = 0;
        float nonDiscountedAmount = 0;
        float discountableAmount = item.getAmount();
        float total;

        if (itemSpecial.getLimit() > 0 && item.getAmount() > itemSpecial.getLimit()) {
            nonDiscountedAmount += (item.getAmount() - itemSpecial.getLimit());
            discountableAmount = itemSpecial.getLimit();
        }

        if (itemSpecial.getRequiredAmount() > 0 && discountableAmount > itemSpecial.getRequiredAmount()) {
            float discountableSet = itemSpecial.getRequiredAmount() + itemSpecial.getDiscountedAmount();
            nonDiscountedAmount += discountableAmount * (itemSpecial.getRequiredAmount() / discountableSet);
            discountedAmount += discountableAmount - nonDiscountedAmount;
        }

        if (itemSpecial.getSetDiscountPrice() > 0) {
            nonDiscountedAmount = discountableAmount % itemSpecial.getRequiredAmount();
            discountedAmount = discountableAmount - nonDiscountedAmount;
        }

        if (discountedAmount <= 0 && discountableAmount > 0 && discountableAmount >= itemSpecial.getRequiredAmount()) {
            discountedAmount = discountableAmount;
        }

        if (discountableAmount < itemSpecial.getRequiredAmount()) {
            nonDiscountedAmount = discountableAmount;
        }

        if (itemSpecial.getSetDiscountPrice() > 0) {
            total = ((discountedAmount / itemSpecial.getRequiredAmount()) * itemSpecial.getSetDiscountPrice())
                    + (nonDiscountedAmount * item.getPrice());
        } else {
            float discountPrice = (1.0F - itemSpecial.getDiscount()) * item.getPrice();
            total = (discountedAmount * discountPrice) + (nonDiscountedAmount * item.getPrice());
        }

        return total;
    }
}
