package com.kata.checkout_order.controllers;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class QueryController extends BaseController {
    QueryController(GroceryItemRepository repository) {
        super(repository);
    }
}
