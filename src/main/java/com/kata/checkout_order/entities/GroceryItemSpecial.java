package com.kata.checkout_order.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroceryItemSpecial {
    private final String itemName;
    // range from 0 to 1, as in 0.2 = 20% off
    private final float discount = 0;

    // value of 0 means no limit
    // can scan more items over the limit but special would not apply
    private final float limit = 0;

    // amount of items or weight of items to enable the discount
    // value of 0 means applies to all items
    private final float requiredAmount = 0;
    // amount of items or weight of items discounted
    private final float discountedAmount = 0;

    // represents "requiredAmount for setDiscountPrice" e.g. "3 for $5.00"
    private final float setDiscountPrice = 0.0F;
}
