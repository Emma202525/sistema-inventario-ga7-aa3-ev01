# Pruebas del módulo

## Pruebas automatizadas
Se incluyen pruebas para:
- Carga del contexto de Spring Boot.
- Consulta de producto por ID.
- Registro de producto.
- Eliminación de producto.
- Búsqueda por nombre.

Ejecutar:

`mvn clean test`

## Pruebas funcionales
1. Abrir `/`.
2. Consultar el inventario.
3. Crear un producto.
4. Confirmar que aparece en la tabla.
5. Buscar el producto.
6. Editarlo.
7. Eliminarlo.
8. Verificar los mensajes mostrados.

## Resultado esperado
Todas las operaciones deben completarse sin errores y las validaciones deben impedir el envío de datos inválidos.
