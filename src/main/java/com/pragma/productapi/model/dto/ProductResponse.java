package com.pragma.productapi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO para enviar datos de salida en los endpoints GET de productos.
 * Incluye información adicional como el identificador único y la fecha de creación.
 */
@Schema(description = "Datos devueltos por los endpoints de consulta de productos")
public record ProductResponse(

    @Schema(description = "Identificador único del producto", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id,

    @Schema(description = "Nombre del producto", example = "Laptop Gamer")
    String name,

    @Schema(description = "Descripción del producto", example = "Laptop con tarjeta gráfica RTX 3060")
    String description,

    @Schema(description = "Precio del producto", example = "1299.99")
    BigDecimal price,

    @Schema(description = "Cantidad en stock", example = "50")
    Integer stock,

    @Schema(description = "Categorías del producto", example = "[\"Electrónicos\", \"Gaming\"]")
    List<String> categories,

    @Schema(description = "Fecha y hora de creación del producto", example = "2023-10-15T14:30:00")
    LocalDateTime createdAt
) {
}