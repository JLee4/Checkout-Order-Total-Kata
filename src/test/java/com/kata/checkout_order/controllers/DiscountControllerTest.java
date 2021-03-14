package com.kata.checkout_order.controllers;

import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DiscountController.class)
public class DiscountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemRepository repository;
}
