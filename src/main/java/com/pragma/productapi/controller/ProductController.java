package com.pragma.productapi.controller;

import com.pragma.productapi.model.dto.ProductRequest;
import com.pragma.productapi.model.dto.ProductResponse;
import com.pragma.productapi.service.ProductService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Gestión de Productos", description = "Endpoints para registrar y consultar productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo producto", 
               description = "Crea un nuevo producto en el sistema con validación de nombre único y precio positivo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "409", description = "El nombre del producto ya existe",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class)))
    })
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Consultar todos los productos", 
               description = "Retorna una lista de todos los productos registrados en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente",
                     content = @Content(mediaType = "application/json",
                     array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class))))
    })
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar un producto por ID", 
               description = "Retorna los detalles de un producto específico dado su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class)))
    })
    public ResponseEntity<ProductResponse> getProductById(
            @Parameter(description = "Identificador único del producto", required = true)
            @PathVariable UUID id) {
        ProductResponse response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar producto por nombre", 
               description = "Busca un producto específico por su nombre exacto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado exitosamente",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class))),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = ProductResponse.class)))
    })
    public ResponseEntity<ProductResponse> getProductByName(
            @Parameter(description = "Nombre del producto a buscar", required = true)
            @RequestParam String name) {
        ProductResponse response = productService.getProductByName(name);
        return ResponseEntity.ok(response);
    }
}