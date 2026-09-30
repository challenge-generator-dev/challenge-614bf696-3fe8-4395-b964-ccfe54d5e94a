# Desarrollo de una API REST con persistencia en H2

Necesitamos crear una API REST que permita a los usuarios registrar y consultar productos. La base de datos será H2 y se documentará con Swagger. Los productos tendrán atributos como nombre, precio, stock y categoría. Se deben prohibir precios negativos y nombres duplicados. El sistema debe manejar correctamente las validaciones y los errores.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | api-rest |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del modelo de datos

**Objetivo:** Definir los atributos y restricciones de los productos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los atributos necesarios para un producto (nombre, precio, stock, categoría).
- Establecer las restricciones para los atributos (precio no negativo, nombre único).

**Entregable:** Modelo de datos con atributos y restricciones definidas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las posibles validaciones y cómo manejarlas.
- Piensa en los edge cases que podrían ocurrir.

</details>

### Fase 2: Implementación de la API REST

**Objetivo:** Crear los endpoints para registrar y consultar productos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar los endpoints POST para registrar un producto y GET para consultar productos.
- Asegurar que las validaciones y restricciones definidas en la fase anterior se apliquen correctamente.

**Entregable:** API REST con endpoints para registrar y consultar productos, con validaciones y restricciones aplicadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar los errores de validación.
- Piensa en la estructura de las respuestas de la API.

</details>

### Fase 3: Documentación con Swagger

**Objetivo:** Documentar la API utilizando Swagger.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Añadir anotaciones Swagger a los endpoints para documentar la API.
- Generar la documentación Swagger y asegurar que esté completa y clara.

**Entregable:** Documentación Swagger completa y clara para la API REST.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo hacer que la documentación sea fácil de entender para los usuarios.
- Piensa en los detalles que deberías incluir en la documentación.

</details>

### Fase 4: Pruebas y optimización

**Objetivo:** Realizar pruebas y optimizar la API.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Realizar pruebas unitarias y de integración para asegurar que la API funcione correctamente.
- Identificar y corregir posibles optimizaciones en la API.

**Entregable:** API REST funcional y optimizada, con pruebas unitarias y de integración.

<details>
<summary>Pistas de conocimiento</summary>

- Considera diferentes escenarios de prueba para asegurar la robustez de la API.
- Piensa en posibles mejoras de rendimiento.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo de datos y por qué es importante en una API REST?
- **paraQueSirve**: ¿Para qué sirve la documentación Swagger en una API REST?
- **comoSeUsa**: ¿Cómo se aplican las validaciones en los endpoints de una API REST?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la optimización de una API REST?

## Criterios de Evaluacion

- Definición correcta del modelo de datos con atributos y restricciones.
- Implementación correcta de los endpoints con validaciones y restricciones.
- Documentación completa y clara utilizando Swagger.
- Pruebas unitarias y de integración que demuestren la funcionalidad y robustez de la API.
- Identificación y corrección de posibles optimizaciones en la API.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
