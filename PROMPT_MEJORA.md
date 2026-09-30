# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/pragma/productapi/controller/ProductControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/productapi/repository/ProductRepositoryTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/productapi/model/dto/ProductRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/model/dto/ProductResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/controller/ProductController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.existsById`: Se invoca `existsById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/productapi/service/ProductService.java` — `ProductRepository.deleteById`: Se invoca `deleteById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.save`: Se invoca `save` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/service/ProductServiceTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.findById`: Se invoca `findById` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.findAll`: Se invoca `findAll` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/productapi/repository/ProductRepositoryTest.java` — `ProductRepository.delete`: Se invoca `delete` sobre `ProductRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: api-rest
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de una API REST con persistencia en H2
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del modelo de datos — objetivo: Definir los atributos y restricciones de los productos. — entregable (NO resolver): Modelo de datos con atributos y restricciones definidas.
- Fase 2: Implementación de la API REST — objetivo: Crear los endpoints para registrar y consultar productos. — entregable (NO resolver): API REST con endpoints para registrar y consultar productos, con validaciones y restricciones aplicadas.
- Fase 3: Documentación con Swagger — objetivo: Documentar la API utilizando Swagger. — entregable (NO resolver): Documentación Swagger completa y clara para la API REST.
- Fase 4: Pruebas y optimización — objetivo: Realizar pruebas y optimizar la API. — entregable (NO resolver): API REST funcional y optimizada, con pruebas unitarias y de integración.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>product-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>product-api</name>
    <description>API REST para gestión de productos con persistencia en H2</description>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Base de datos H2 -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Documentación Swagger/OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

// === ARCHIVO: src/main/java/com/pragma/productapi/ProductApiApplication.java ===
package com.pragma.productapi;


import com.pragma.productapi.model.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public String demoInitialization() {
        // Este método se ejecuta al iniciar la aplicación
        // para demostrar que la aplicación está lista para recibir peticiones
        System.out.println("Product API iniciada y lista para recibir peticiones");
        return "Product API Ready";
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración de Spring Boot
spring.application.name=product-api

# Configuración de la base de datos H2
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Habilitar consola de H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuración de JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

# Configuración de Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.operationsSorter=alpha
springdoc.swagger-ui.enabled=true

# Configuración de logging
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=INFO
logging.level.com.pragma.productapi=DEBUG

// === ARCHIVO: src/main/java/com/pragma/productapi/repository/ProductRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/model/dto/ProductRequest.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/model/dto/ProductResponse.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/model/entity/Product.java ===
package com.pragma.productapi.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @Column(length = 50)
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    public Product() {
    }

    public Product(UUID id, String name, BigDecimal price, Integer stock, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = java.time.LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.time.LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/config/OpenApiConfig.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/controller/ProductController.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/service/ProductService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/GlobalExceptionHandler.java ===
package com.pragma.productapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        logger.error("Recurso no encontrado: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "NOT_FOUND",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateProductNameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateProductNameException(
            DuplicateProductNameException ex, WebRequest request) {

        logger.error("Nombre de producto duplicado: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {

        logger.error("Error de validación en la solicitud");

        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        error -> error.getDefaultMessage() != null 
                                ? error.getDefaultMessage() 
                                : "Valor inválido",
                        (existing, replacement) -> existing
                ));

        ValidationErrorResponse errorResponse = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                "Error de validación en los datos enviados",
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now(),
                errors
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {

        logger.error("Argumento ilegal: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex, WebRequest request) {

        logger.error("Error interno del servidor: {}", ex.getMessage(), ex);

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_SERVER_ERROR",
                "Ha ocurrido un error interno. Por favor, contacte al administrador.",
                request.getDescription(false).replace("uri=", ""),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public record ErrorResponse(
            int status,
            String error,
            String message,
            String path,
            LocalDateTime timestamp
    ) {}

    public record ValidationErrorResponse(
            int status,
            String error,
            String message,
            String path,
            LocalDateTime timestamp,
            Map<String, String> fieldErrors
    ) {}
}

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/ResourceNotFoundException.java ===
package com.pragma.productapi.exception;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceType;
    private final String searchCriteria;
    private final UUID resourceId;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceType = "Resource";
        this.searchCriteria = message;
        this.resourceId = null;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.resourceType = "Resource";
        this.searchCriteria = message;
        this.resourceId = null;
    }

    public ResourceNotFoundException(String resourceType, String fieldName, Object fieldValue) {
        super(String.format("%s no encontrado con %s: %s", resourceType, fieldName, fieldValue));
        this.resourceType = resourceType;
        this.searchCriteria = String.format("%s = %s", fieldName, fieldValue);
        this.resourceId = fieldValue instanceof UUID ? (UUID) fieldValue : null;
    }

    public ResourceNotFoundException(String resourceType, UUID id) {
        super(String.format("%s no encontrado con ID: %s", resourceType, id));
        this.resourceType = resourceType;
        this.searchCriteria = "ID";
        this.resourceId = id;
    }

    public ResourceNotFoundException(String resourceType, String fieldName, Object fieldValue, Throwable cause) {
        super(String.format("%s no encontrado con %s: %s", resourceType, fieldName, fieldValue), cause);
        this.resourceType = resourceType;
        this.searchCriteria = String.format("%s = %s", fieldName, fieldValue);
        this.resourceId = fieldValue instanceof UUID ? (UUID) fieldValue : null;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public boolean hasResourceId() {
        return resourceId != null;
    }

    @Override
    public String toString() {
        return String.format("ResourceNotFoundException{type='%s', criteria='%s', id=%s, message='%s'}",
                resourceType, searchCriteria, resourceId, getMessage());
    }
}

// === ARCHIVO: src/main/java/com/pragma/productapi/exception/DuplicateProductNameException.java ===
package com.pragma.productapi.exception;

public class DuplicateProductNameException extends RuntimeException {

    private final String productName;

    public DuplicateProductNameException(String productName) {
        super(String.format("Ya existe un producto registrado con el nombre: %s", productName));
        this.productName = productName;
    }

    public DuplicateProductNameException(String productName, String message) {
        super(message);
        this.productName = productName;
    }

    public DuplicateProductNameException(String productName, Throwable cause) {
        super(String.format("Ya existe un producto registrado con el nombre: %s", productName), cause);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "DuplicateProductNameException{" +
                "productName='" + productName + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}

// === ARCHIVO: src/test/java/com/pragma/productapi/controller/ProductControllerTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/productapi/service/ProductServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/productapi/repository/ProductRepositoryTest.java ===
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
```
