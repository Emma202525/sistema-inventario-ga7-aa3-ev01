package co.edu.sena.inventario.service;

import co.edu.sena.inventario.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la lógica del inventario.
 */
class ProductoServiceTest {

    @Test
    void debeBuscarProductoPorId() {
        ProductoService service = new ProductoService();

        Producto producto = service.buscarPorId(1).orElse(null);

        assertNotNull(producto);
        assertEquals("Arroz 1 kg", producto.getNombre());
    }

    @Test
    void debeRegistrarProducto() {
        ProductoService service = new ProductoService();
        int cantidadInicial = service.listar().size();

        service.guardar(new Producto(null, "Pan", "Panadería", 10, 2000.0));

        assertEquals(cantidadInicial + 1, service.listar().size());
    }

    @Test
    void debeEliminarProducto() {
        ProductoService service = new ProductoService();

        assertTrue(service.eliminar(2));
        assertTrue(service.buscarPorId(2).isEmpty());
    }

    @Test
    void debeBuscarPorNombre() {
        ProductoService service = new ProductoService();

        assertEquals(1, service.buscar("Arroz").size());
    }
}
