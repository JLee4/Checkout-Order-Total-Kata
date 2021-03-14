package com.kata.checkout_order.controllers;

import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    final GroceryItemRepository repository;

    @Autowired
    BaseController(@Qualifier("groceryItemRepository") GroceryItemRepository repository) {
        this.repository = repository;
    }
}
