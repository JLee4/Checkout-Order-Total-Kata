package com.kata.checkout_order.entities;

import lombok.Setter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GroceryItem {
    @NonNull private final String name;

    // number of items or number of pounds for weight
    @NonNull private final float amount;

    // positive decimal number, per unit or per pound
    @NonNull private final float price;

    // Limit of specials on one grocery item not specified, assuming only one special at a time
    @Setter
    private GroceryItemSpecial special;
}

@Getter
@AllArgsConstructor
class GroceryItemSpecial {
    // range from 0 to 1, as in 0.2 = 20% off
    private final float discount = 0;

    // value of 0 means no limit
    private final float limit = 0;

    // amount of items or weight of items to enable the discount
    // value of 0 means applies to all items
    private final float requiredAmount = 0;
    // amount of items or weight of items discounted
    private final float discountedAmount = 0;

    // represents "requiredAmount for setDiscountPrice" e.g. "3 for $5.00"
    private final float setDiscountPrice = 0.0F;
}


