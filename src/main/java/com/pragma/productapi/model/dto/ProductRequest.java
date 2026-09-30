package com.pragma.productapi.model.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO para recibir datos de entrada en los endpoints POST y PUT de productos.
 * Contiene las validaciones necesarias para garantizar la integridad de los datos.
 */
@Schema(description = "Datos requeridos para crear o actualizar un producto")
public record ProductRequest(

    @Schema(description = "Nombre del producto", example = "Laptop Gamer")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    String name,

    @Schema(description = "Descripción del producto", example = "Laptop con tarjeta gráfica RTX 3060")
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    String description,

    @Schema(description = "Precio del producto", example = "1299.99")
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    BigDecimal price,

    @Schema(description = "Cantidad en stock", example = "50")
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    Integer stock,

    @Schema(description = "Categorías del producto", example = "[\"Electrónicos\", \"Gaming\"]")
    @NotEmpty(message = "Debe proporcionar al menos una categoría")
    @Size(max = 5, message = "No puede tener más de 5 categorías")
    @UniqueElements(message = "Las categorías deben ser únicas")
    List<@NotBlank(message = "Cada categoría debe tener un nombre") @Size(max = 30, message = "Cada categoría no puede exceder los 30 caracteres") String> categories
) {
}