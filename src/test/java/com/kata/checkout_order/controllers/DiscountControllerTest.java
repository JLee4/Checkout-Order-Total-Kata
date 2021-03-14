package com.kata.checkout_order.controllers;

import com.google.gson.Gson;
import com.kata.checkout_order.entities.GroceryItemSpecial;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DiscountController.class)
public class DiscountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemRepository repository;

    private final Gson gson = new Gson();

    @Test
    public void addItemSpecial_UpdatesReturnsTotal() throws Exception {
        GroceryItemSpecial expectedSpecial =
                new GroceryItemSpecial("abc", 50.0F, 0, 0, 0, 0);
        when(repository.addItemSpecial(any())).thenReturn(true);
        this.mockMvc
                .perform(post("/discount")
                        .contentType(APPLICATION_JSON).content(gson.toJson(expectedSpecial))
                )
                .andExpect(status().isOk()).andExpect(content().string(String.valueOf(true)));
    }
}
