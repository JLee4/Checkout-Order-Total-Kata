package com.kata.checkout_order.entities;

import lombok.Setter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GroceryItem {
    @NonNull private final String name;

    // positive decimal number, per unit or per pound
    private final float price;

    private final boolean isWeighed;

    // number of items or number of pounds for weight
    private float amount = 0.0F;

    public void setAmount(float amount) {
        if (!isWeighed && amount % 1.0F != 0.0F) {
            throw new IllegalArgumentException("Non-weighed items cannot be fractional");
        }
        this.amount = amount;
    }

    @Setter
    private float currentItemTotal = 0.0F;

    // Limit of specials on one grocery item not specified, assuming only one special at a time
    @Setter
    private GroceryItemSpecial special;
}
