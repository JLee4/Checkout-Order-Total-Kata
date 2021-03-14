package com.kata.checkout_order.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class GroceryItemSpecial {
    private final String itemName;
    // range from 0 to 1, as in 0.2 = 20% off
    private final float discount;

    // value of 0 means no limit
    // can scan more items over the limit but special would not apply
    private final float limit;

    // amount of items or weight of items to enable the discount
    // value of 0 means applies to all items
    private final float requiredAmount;
    // amount of items or weight of items discounted
    private final float discountedAmount;

    // represents "requiredAmount for setDiscountPrice" e.g. "3 for $5.00"
    private final float setDiscountPrice;

    public GroceryItemSpecial(
            String itemName,
            float discount,
            float limit,
            float requiredAmount,
            float discountedAmount,
            float setDiscountPrice
    ) {
        if (itemName == null) {
            throw new IllegalArgumentException("Special must have a name");
        }
        if (discount == 0 && setDiscountPrice == 0) {
            throw new IllegalArgumentException("Special must have a discount or a discount as a set");
        }
        if (setDiscountPrice != 0 && requiredAmount == 0) {
            throw new IllegalArgumentException("Special with discount as a set must have a required amount of items");
        }
        if (discountedAmount != 0 && requiredAmount == 0) {
            throw new IllegalArgumentException("Special must have a required amount");
        }
        if (requiredAmount < limit && requiredAmount != 0) {
            throw new IllegalArgumentException("Special limit cannot be less than the required amount of items");
        }

        this.itemName = itemName;
        this.discount = discount;
        this.limit = limit;
        this.requiredAmount = requiredAmount;
        this.discountedAmount = discountedAmount;
        this.setDiscountPrice = setDiscountPrice;
    }
}
