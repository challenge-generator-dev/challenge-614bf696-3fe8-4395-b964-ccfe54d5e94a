package com.pragma.productapi.repository;

import com.pragma.productapi.model.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testExistsByName_ReturnsTrue_WhenProductExists() {
        Product product = createProduct("Laptop", new BigDecimal("1500.00"));
        entityManager.persist(product);
        entityManager.flush();

        boolean exists = productRepository.existsByName("Laptop");

        assertTrue(exists);
    }

    @Test
    void testExistsByName_ReturnsFalse_WhenProductDoesNotExist() {
        boolean exists = productRepository.existsByName("NonExistent");

        assertFalse(exists);
    }

    @Test
    void testFindByName_ReturnsProduct_WhenExists() {
        Product product = createProduct("Mouse", new BigDecimal("25.00"));
        entityManager.persist(product);
        entityManager.flush();

        Optional<Product> found = productRepository.findByName("Mouse");

        assertTrue(found.isPresent());
        assertEquals("Mouse", found.get().getName());
        assertEquals(new BigDecimal("25.00"), found.get().getPrice());
    }

    @Test
    void testFindByName_ReturnsEmpty_WhenNotExists() {
        Optional<Product> found = productRepository.findByName("NonExistent");

        assertTrue(found.isEmpty());
    }

    @Test
    void testSaveAndFindById() {
        Product product = createProduct("Keyboard", new BigDecimal("45.00"));
        product.setStock(25);
        product.setCategory("Electronics");

        Product saved = entityManager.persist(product);
        entityManager.flush();
        entityManager.clear();

        Optional<Product> found = productRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Keyboard", found.get().getName());
        assertEquals(25, found.get().getStock());
    }

    @Test
    void testFindAll_ReturnsAllProducts() {
        Product product1 = createProduct("Laptop", new BigDecimal("1500.00"));
        Product product2 = createProduct("Mouse", new BigDecimal("25.00"));

        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.flush();

        var products = productRepository.findAll();

        assertEquals(2, products.size());
    }

    @Test
    void testDeleteProduct() {
        Product product = createProduct("ToDelete", new BigDecimal("10.00"));
        Product saved = entityManager.persist(product);
        entityManager.flush();

        productRepository.delete(saved);
        entityManager.flush();

        Optional<Product> found = productRepository.findById(saved.getId());
        assertTrue(found.isEmpty());
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