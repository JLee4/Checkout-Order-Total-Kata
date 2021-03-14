package com.kata.checkout_order.controllers;

import com.google.gson.Gson;
import com.kata.checkout_order.entities.GroceryItem;
import com.kata.checkout_order.repositories.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemRepository repository;

    private final float expectedTotal = 10.0F;

    private final Gson gson = new Gson();

    private final GroceryItem expectedItem = new GroceryItem("abc", 0.0F, false);

    @Test
    public void addScannedItem_UpdatesReturnsTotal() throws Exception {
        expectedItem.setAmount(1);
        when(repository.addScannedItem(anyString(), anyFloat())).thenReturn(expectedTotal);
        this.mockMvc.perform(post("/item").contentType(APPLICATION_JSON).content(gson.toJson(expectedItem)))
                .andExpect(status().isOk()).andExpect(content().string(String.valueOf(expectedTotal)));
    }

    @Test
    public void removeScannedItem_UpdatesReturnsTotal() throws Exception {
        expectedItem.setAmount(1);
        when(repository.removeScannedItem(anyString(), anyFloat())).thenReturn(expectedTotal);
        this.mockMvc.perform(delete("/item").contentType(APPLICATION_JSON).content(gson.toJson(expectedItem)))
                .andExpect(status().isOk()).andExpect(content().string(String.valueOf(expectedTotal)));
    }
}
