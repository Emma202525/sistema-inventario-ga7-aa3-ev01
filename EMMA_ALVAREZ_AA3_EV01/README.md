# Sistema de Inventario para Tiendas - Spring Boot

## Evidencia
GA7-220501096-AA3-EV01 - Codificación de módulos del software stand-alone, web y móvil.

## Descripción
Aplicación web desarrollada con el framework Spring Boot para administrar el inventario básico de una pequeña tienda.

## Framework y tecnologías
- Spring Boot 3.3.5
- Spring MVC
- Thymeleaf
- Jakarta Validation
- Java 17
- Maven
- HTML5 y CSS3
- Git/GitHub
- JUnit / Spring Boot Test

## Funcionalidades
- Consultar inventario.
- Buscar productos por nombre.
- Registrar productos.
- Editar productos.
- Eliminar productos.
- Validar nombre, categoría, cantidad y precio.
- Mostrar mensajes de operación.

## Arquitectura
Se aplica una estructura por capas:
- `model`: entidad Producto.
- `service`: lógica de negocio.
- `controller`: control de solicitudes HTTP.
- `templates`: vistas Thymeleaf.
- `static/css`: estilos.

## Ejecución
Requisitos:
- JDK 17
- Maven 3.9 o superior
- IDE recomendado: IntelliJ IDEA, NetBeans o Eclipse.

Desde la raíz:

```bash
mvn clean test
mvn spring-boot:run
```

Abrir:
http://localhost:8080/

También puede generarse el JAR con:

```bash
mvn clean package
java -jar target/inventario-springboot-1.0.0.jar
```

## Versionamiento
Crear un repositorio llamado:
`sistema-inventario-ga7-aa3-ev01`

Comandos:

```bash
git init
git add .
git commit -m "GA7-AA3-EV01 - modulo inventario Spring Boot"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/sistema-inventario-ga7-aa3-ev01.git
git push -u origin main
```

Después de crear el repositorio, actualizar `repositorio.txt`.

## Nota
Para mantener el módulo sencillo y enfocado en la evidencia, los datos se almacenan en memoria. Al reiniciar la aplicación se cargan nuevamente los productos de ejemplo.
