package com.pragma.productapi.controller;

import com.pragma.productapi.model.dto.ProductRequest;
import com.pragma.productapi.model.dto.ProductResponse;
import com.pragma.productapi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void testCreateProduct_ReturnsCreatedStatus() throws Exception {
        ProductRequest request = new ProductRequest(
                "Laptop",
                new BigDecimal("1500.00"),
                10,
                "Electronics"
        );

        ProductResponse response = new ProductResponse(
                UUID.randomUUID(),
                "Laptop",
                new BigDecimal("1500.00"),
                10,
                "Electronics"
        );

        when(productService.createProduct(any(ProductRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "name": "Laptop",
                                "price": 1500.00,
                                "stock": 10,
                                "category": "Electronics"
                            }
                            """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(1500.00));
    }

    @Test
    void testGetAllProducts_ReturnsProductList() throws Exception {
        List<ProductResponse> products = List.of(
                new ProductResponse(UUID.randomUUID(), "Laptop", new BigDecimal("1500.00"), 10, "Electronics"),
                new ProductResponse(UUID.randomUUID(), "Mouse", new BigDecimal("25.00"), 50, "Electronics")
        );

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[1].name").value("Mouse"));
    }

    @Test
    void testGetProductById_ReturnsProduct() throws Exception {
        UUID productId = UUID.randomUUID();
        ProductResponse response = new ProductResponse(
                productId, "Laptop", new BigDecimal("1500.00"), 10, "Electronics"
        );

        when(productService.getProductById(productId)).thenReturn(response);

        mockMvc.perform(get("/api/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.category").value("Electronics"));
    }

    @Test
    void testGetProductById_ReturnsNotFound() throws Exception {
        UUID productId = UUID.randomUUID();

        when(productService.getProductById(productId)).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/api/products/" + productId))
                .andExpect(status().isNotFound());
    }
}