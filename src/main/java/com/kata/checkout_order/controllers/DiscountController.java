package com.kata.checkout_order.controllers;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController extends BaseController {
    DiscountController(GroceryItemRepository repository) {
        super(repository);
    }

    @PostMapping("")
    boolean addItemSpecial(@RequestBody GroceryItemSpecial newItem) {
        return this.repository.addItemSpecial(newItem);
    }
}
