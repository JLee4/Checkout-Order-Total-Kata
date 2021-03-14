package com.kata.checkout_order.controllers;

import com.google.gson.Gson;
import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.kata.checkout_order.constants.GroceryItemConstants.AVAILABLE_GROCERY_ITEMS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QueryController.class)
public class QueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemRepository repository;

    private final Gson gson = new Gson();

    @Test
    public void getTotal_returnsValidTotal() throws Exception {
        float expectedTotal = 10.0F;
        when(repository.getRunningTotal()).thenReturn(expectedTotal);
        this.mockMvc.perform(get("/query/total")).andExpect(status().isOk()).andExpect(content().string(String.valueOf(expectedTotal)));
    }

    @Test
    public void getItems_returnsValidItems() throws Exception {
        List<GroceryItem> expectedItems = new ArrayList<>();
        expectedItems.add(AVAILABLE_GROCERY_ITEMS.get(0));
        when(repository.getItems()).thenReturn(expectedItems);
        this.mockMvc.perform(get("/query/items")).andExpect(status().isOk()).andExpect(content().json(gson.toJson(expectedItems)));
    }

    @Test
    public void getAvailableItems_returnsValidItems() throws Exception {
        when(repository.getAvailableGroceryItems()).thenReturn(AVAILABLE_GROCERY_ITEMS);
        this.mockMvc.perform(get("/query/available-items")).andExpect(status().isOk()).andExpect(content().json(gson.toJson(AVAILABLE_GROCERY_ITEMS)));
    }
}
