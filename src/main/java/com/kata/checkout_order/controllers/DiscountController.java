package com.kata.checkout_order.controllers;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController extends BaseController {
    DiscountController(GroceryItemRepository repository) {
        super(repository);
    }
}
