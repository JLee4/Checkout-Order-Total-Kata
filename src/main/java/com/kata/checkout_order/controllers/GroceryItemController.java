package com.kata.checkout_order.controllers;

import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class GroceryItemController extends BaseController {
    GroceryItemController(GroceryItemRepository repository) {
        super(repository);
    }

    @PostMapping("")
    float addScannedItem(@RequestBody GroceryItem newItem) {
        return this.repository.addScannedItem(newItem.getName(), newItem.getAmount());
    }

    @DeleteMapping("")
    float removeScannedItem(@RequestBody GroceryItem removedItem) {
        return this.repository.removeScannedItem(removedItem.getName(), removedItem.getAmount());
    }
}
