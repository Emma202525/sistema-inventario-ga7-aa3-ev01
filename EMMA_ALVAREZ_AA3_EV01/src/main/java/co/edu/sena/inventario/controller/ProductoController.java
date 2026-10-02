package co.edu.sena.inventario.controller;

import co.edu.sena.inventario.model.Producto;
import co.edu.sena.inventario.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador MVC del módulo de productos.
 * Atiende las solicitudes web y conecta las vistas con el servicio.
 */
@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * GET: muestra el inventario y permite realizar búsquedas.
     */
    @GetMapping({"/", "/productos"})
    public String listar(@RequestParam(required = false) String buscar,
                         Model model) {
        model.addAttribute("productos", productoService.buscar(buscar));
        model.addAttribute("buscar", buscar == null ? "" : buscar);
        return "productos";
    }

    /**
     * GET: muestra el formulario para registrar un producto.
     */
    @GetMapping("/productos/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Registrar producto");
        return "formulario";
    }

    /**
     * POST: valida y registra un producto nuevo.
     */
    @PostMapping("/productos/guardar")
    public String guardar(@Valid @ModelAttribute Producto producto,
                          BindingResult resultado,
                          Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", "Registrar producto");
            return "formulario";
        }

        productoService.guardar(producto);
        return "redirect:/productos?mensaje=Producto+registrado+correctamente";
    }

    /**
     * GET: carga los datos de un producto para editarlo.
     */
    @GetMapping("/productos/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Producto producto = productoService.buscarPorId(id).orElse(null);

        if (producto == null) {
            return "redirect:/productos?mensaje=Producto+no+encontrado";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar producto");
        return "formulario";
    }

    /**
     * POST: actualiza un producto existente.
     */
    @PostMapping("/productos/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @Valid @ModelAttribute Producto producto,
                             BindingResult resultado,
                             Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", "Editar producto");
            return "formulario";
        }

        productoService.actualizar(id, producto);
        return "redirect:/productos?mensaje=Producto+actualizado+correctamente";
    }

    /**
     * GET: elimina un producto seleccionado.
     */
    @GetMapping("/productos/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "redirect:/productos?mensaje=Producto+eliminado+correctamente";
    }
}
