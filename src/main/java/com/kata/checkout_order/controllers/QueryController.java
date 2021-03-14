package com.kata.checkout_order.controllers;
import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/query")
public class QueryController extends BaseController {
    QueryController(GroceryItemRepository repository) {
        super(repository);
    }

    @GetMapping("/total")
    float getTotal() {
        return 0;
    }

    @GetMapping("/items")
    Collection<GroceryItem> getItems() {
        return null;
    }

    @GetMapping("/available-items")
    Collection<GroceryItem> getAvailableGroceryItems() {
        return null;
    }
}
