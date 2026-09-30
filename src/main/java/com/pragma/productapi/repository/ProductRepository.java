package com.pragma.productapi.repository;

import com.pragma.productapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio JPA para operaciones de persistencia sobre la entidad Product.
 * Proporciona métodos CRUD estándar y consultas personalizadas para la gestión de productos.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Verifica si existe un producto con el nombre especificado.
     * @param name Nombre del producto a buscar.
     * @return true si existe un producto con ese nombre, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Busca un producto por su nombre.
     * @param name Nombre del producto a buscar.
     * @return Optional que contiene el producto si existe, vacío si no.
     */
    Optional<Product> findByName(String name);
}