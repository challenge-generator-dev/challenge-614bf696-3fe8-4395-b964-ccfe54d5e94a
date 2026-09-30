package com.pragma.productapi.service;

import com.pragma.productapi.exception.DuplicateProductNameException;
import com.pragma.productapi.exception.ResourceNotFoundException;
import com.pragma.productapi.model.dto.ProductRequest;
import com.pragma.productapi.model.dto.ProductResponse;
import com.pragma.productapi.model.entity.Product;
import com.pragma.productapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        logger.info("Intentando crear producto con nombre: {}", request.name());

        validateProductRequest(request);
        checkDuplicateName(request.name());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(request.category());
        product.setDescription(request.description());

        Product savedProduct = productRepository.save(product);
        logger.info("Producto creado exitosamente con ID: {}", savedProduct.getId());

        return mapToResponse(savedProduct);
    }

    @Transactional(readOnly = true)
    public ProductResponse getProductById(UUID id) {
        logger.info("Buscando producto con ID: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Producto no encontrado con ID: {}", id);
                    return new ResourceNotFoundException("Producto no encontrado con ID: " + id);
                });

        return mapToResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductResponse getProductByName(String name) {
        logger.info("Buscando producto con nombre: {}", name);

        Product product = productRepository.findByName(name)
                .orElseThrow(() -> {
                    logger.warn("Producto no encontrado con nombre: {}", name);
                    return new ResourceNotFoundException("Producto no encontrado con nombre: " + name);
                });

        return mapToResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        logger.info("Obteniendo todos los productos");

        List<Product> products = productRepository.findAll();
        logger.info("Se encontraron {} productos", products.size());

        return products.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        logger.info("Actualizando producto con ID: {}", id);

        validateProductRequest(request);

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Producto no encontrado para actualización con ID: {}", id);
                    return new ResourceNotFoundException("Producto no encontrado con ID: " + id);
                });

        if (!existingProduct.getName().equals(request.name())) {
            checkDuplicateName(request.name());
            existingProduct.setName(request.name());
        }

        existingProduct.setPrice(request.price());
        existingProduct.setStock(request.stock());
        existingProduct.setCategory(request.category());
        existingProduct.setDescription(request.description());

        Product updatedProduct = productRepository.save(existingProduct);
        logger.info("Producto actualizado exitosamente con ID: {}", updatedProduct.getId());

        return mapToResponse(updatedProduct);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        logger.info("Eliminando producto con ID: {}", id);

        if (!productRepository.existsById(id)) {
            logger.warn("Producto no encontrado para eliminación con ID: {}", id);
            throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
        }

        productRepository.deleteById(id);
        logger.info("Producto eliminado exitosamente con ID: {}", id);
    }

    private void validateProductRequest(ProductRequest request) {
        if (request.price() == null) {
            throw new IllegalArgumentException("El precio del producto es obligatorio");
        }

        if (request.price().compareTo(BigDecimal.ZERO) < 0) {
            logger.error("Intento de crear producto con precio negativo: {}", request.price());
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (request.stock() == null || request.stock() < 0) {
            logger.error("Intento de crear producto con stock inválido: {}", request.stock());
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        if (request.name() == null || request.name().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }

        if (request.category() == null || request.category().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría del producto es obligatoria");
        }
    }

    private void checkDuplicateName(String name) {
        if (productRepository.existsByName(name)) {
            logger.warn("Intento de crear producto con nombre duplicado: {}", name);
            throw new DuplicateProductNameException("Ya existe un producto con el nombre: " + name);
        }
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getDescription()
        );
    }
}