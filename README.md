# Checkout-Order-Total-Kata

## Instructions

1. 

## Description

Project is part of a grocery point-of-sale system. 
Project deliverable is the business logic to calculate the pre-tax total price as items are scanned or entered at checkout.

This project uses Java 8 for best compatibility and Gradle for build automation.

### Project Requirements

* Keep a running total of items including any discounts or specials
* Expose functions for use like an API (Doesn't necessarily imply a REST API)
* Accept inputs for an item or an item and its weight such as "can of soup" or "ground beef, 1 lb"
* Accept inputs to add or remove an item
* Ability to query the total
* Accept inputs to create a special for a set of items
* Accept inputs to discount an existing item

### Project Use Cases

* Accept a scanned item. The total should reflect an increase by the per-unit price after the scan. You will need a way to configure the prices of scannable items prior to being scanned.
* Accept a scanned item and a weight. The total should reflect an increase of the price of the item for the given weight.
* Support a markdown. A marked-down item will reflect the per-unit cost less the markdown when scanned. A weighted item with a markdown will reflect that reduction in cost per unit.
* Support a special in the form of "Buy N items get M at %X off." For example, "Buy 1 get 1 free" or "Buy 2 get 1 half off."
* Support "Buy N, get M of equal or lesser value for %X off" on weighted items. For example, "Buy 2 pounds of ground beef, get 1 pound half off."
* Support a special in the form of "N for $X." For example, "3 for $5.00"
* Support a limit on specials, for example, "buy 2 get 1 free, limit 6" would prevent getting a third free item.
* Support removing a scanned item, keeping the total correct after possibly invalidating a special.

### Project Constraints
* Sales tax is not considered
* Items can be sold per unit
* Items can be sold by weight (Pounds are fine, but stay consistent)
* Items can be discounted
* Limits can be placed on number of items
    * Usually part of a discounted set
* Items can be discounted as part of a set
    * Examples:
        * "Buy one, get one free! Limit 6."
        * "Buy two, get one half off!"
        * "Three cans for $5.00!"
* No database layer, application is run in memory

### Reference

https://github.com/PillarTechnology/kata-checkout-order-total
