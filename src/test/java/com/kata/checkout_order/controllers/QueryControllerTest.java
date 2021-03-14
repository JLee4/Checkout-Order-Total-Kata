package com.kata.checkout_order.controllers;

import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    public void getTotal_returnsValidTotal() throws Exception {
        float expectedTotal = 10.0F;
        when(repository.getRunningTotal()).thenReturn(expectedTotal);
        this.mockMvc.perform(get("/query/total")).andExpect(status().isOk()).andExpect(content().string(String.valueOf(expectedTotal)));
    }

    @Test
    public void getItems_returnsValidItems() {
    }

    @Test
    public void getAvailableItems_returnsValidItems() {
    }
}
