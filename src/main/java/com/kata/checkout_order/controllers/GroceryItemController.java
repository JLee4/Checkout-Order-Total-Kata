package com.kata.checkout_order.controllers;

import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class GroceryItemController extends BaseController {
    GroceryItemController(GroceryItemRepository repository) {
        super(repository);
    }
}
