package com.pragma.productapi.config;


import com.pragma.productapi.model.entity.Product;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API")
                        .version("1.0")
                        .description("API REST para la gestión de productos con persistencia en H2. " +
                                "Permite registrar y consultar productos con validaciones completas.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@pragma.com")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de desarrollo local")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Token de autenticación JWT")));
    }

    @Bean
    public io.swagger.v3.oas.models.OpenCustomizer openApiCustomizer() {
        return api -> api.getPaths().values().forEach(pathItem -> {
            pathItem.readOperations().forEach(operation -> {
                operation.addTagsItem("Gestión de Productos");
            });
        });
    }
}