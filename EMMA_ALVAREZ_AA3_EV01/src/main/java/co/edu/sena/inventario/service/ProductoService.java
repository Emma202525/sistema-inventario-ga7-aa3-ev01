package co.edu.sena.inventario.service;

import co.edu.sena.inventario.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene la lógica de negocio del inventario.
 */
@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private int siguienteId = 4;

    /**
     * Carga datos de ejemplo al iniciar el servicio.
     */
    public ProductoService() {
        productos.add(new Producto(1, "Arroz 1 kg", "Granos", 20, 4500.0));
        productos.add(new Producto(2, "Aceite 1 L", "Abarrotes", 15, 7500.0));
        productos.add(new Producto(3, "Galletas", "Snacks", 30, 2500.0));
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public List<Producto> buscar(String texto) {
        if (texto == null || texto.isBlank()) {
            return listar();
        }

        String criterio = texto.toLowerCase().trim();

        return productos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(criterio))
                .toList();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void guardar(Producto producto) {
        producto.setId(siguienteId++);
        productos.add(producto);
    }

    public boolean actualizar(Integer id, Producto datos) {
        Optional<Producto> resultado = buscarPorId(id);

        if (resultado.isEmpty()) {
            return false;
        }

        Producto producto = resultado.get();
        producto.setNombre(datos.getNombre());
        producto.setCategoria(datos.getCategoria());
        producto.setCantidad(datos.getCantidad());
        producto.setPrecio(datos.getPrecio());

        return true;
    }

    public boolean eliminar(Integer id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}
