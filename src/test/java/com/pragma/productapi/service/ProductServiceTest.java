package com.pragma.productapi.service;

import com.pragma.productapi.exception.DuplicateProductNameException;
import com.pragma.productapi.exception.ResourceNotFoundException;
import com.pragma.productapi.model.dto.ProductRequest;
import com.pragma.productapi.model.dto.ProductResponse;
import com.pragma.productapi.model.entity.Product;
import com.pragma.productapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testCreateProduct_Success() {
        ProductRequest request = new ProductRequest(
                "Laptop",
                new BigDecimal("1500.00"),
                10,
                "Electronics"
        );

        Product savedProduct = new Product();
        savedProduct.setId(UUID.randomUUID());
        savedProduct.setName("Laptop");
        savedProduct.setPrice(new BigDecimal("1500.00"));
        savedProduct.setStock(10);
        savedProduct.setCategory("Electronics");

        when(productRepository.existsByName("Laptop")).thenReturn(false);
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        ProductResponse response = productService.createProduct(request);

        assertNotNull(response);
        assertEquals("Laptop", response.name());
        assertEquals(new BigDecimal("1500.00"), response.price());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testCreateProduct_DuplicateName_ThrowsException() {
        ProductRequest request = new ProductRequest(
                "Laptop",
                new BigDecimal("1500.00"),
                10,
                "Electronics"
        );

        when(productRepository.existsByName("Laptop")).thenReturn(true);

        assertThrows(DuplicateProductNameException.class, () -> {
            productService.createProduct(request);
        });

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void testGetAllProducts_ReturnsList() {
        List<Product> products = List.of(
                createProduct("Laptop", new BigDecimal("1500.00")),
                createProduct("Mouse", new BigDecimal("25.00"))
        );

        when(productRepository.findAll()).thenReturn(products);

        List<ProductResponse> responses = productService.getAllProducts();

        assertNotNull(responses);
        assertEquals(2, responses.size());
    }

    @Test
    void testGetProductById_Success() {
        UUID productId = UUID.randomUUID();
        Product product = createProduct("Laptop", new BigDecimal("1500.00"));
        product.setId(productId);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<ProductResponse> response = productService.getProductById(productId);

        assertTrue(response.isPresent());
        assertEquals("Laptop", response.get().name());
    }

    @Test
    void testGetProductById_NotFound_ThrowsException() {
        UUID productId = UUID.randomUUID();

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            productService.getProductById(productId);
        });
    }

    @Test
    void testGetProductByName_Success() {
        Product product = createProduct("Laptop", new BigDecimal("1500.00"));

        when(productRepository.findByName("Laptop")).thenReturn(Optional.of(product));

        Optional<ProductResponse> response = productService.getProductByName("Laptop");

        assertTrue(response.isPresent());
        assertEquals("Laptop", response.get().name());
    }

    @Test
    void testGetProductByName_NotFound() {
        when(productRepository.findByName("NonExistent")).thenReturn(Optional.empty());

        Optional<ProductResponse> response = productService.getProductByName("NonExistent");

        assertTrue(response.isEmpty());
    }

    private Product createProduct(String name, BigDecimal price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(10);
        product.setCategory("Electronics");
        return product;
    }
}