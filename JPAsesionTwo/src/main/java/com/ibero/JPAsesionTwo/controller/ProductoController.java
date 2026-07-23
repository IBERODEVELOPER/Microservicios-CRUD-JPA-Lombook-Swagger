package com.ibero.JPAsesionTwo.controller;


import com.ibero.JPAsesionTwo.entity.Producto;
import com.ibero.JPAsesionTwo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/producto/listar")
    public ResponseEntity<List<Producto>> listarProducto() {
        List<Producto> productos = productoService.listarProducto();
        return ResponseEntity.ok(productos);
    }

    @GetMapping(value = "/producto/obtenerById/{id}")
    public ResponseEntity<Producto> obtenerProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.ObtenerProducto(id);
        return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/producto/create")
    public ResponseEntity<Producto> processProducto(@RequestBody Producto producto) {
       Producto productosave = productoService.guardarProducto(producto);
       return ResponseEntity.status(HttpStatus.CREATED).body(productosave);
    }

    @PutMapping(value = "/producto/update/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Optional<Producto> ObtenerProductoExiste = productoService.ObtenerProducto(id);
        if (ObtenerProductoExiste.isPresent()){
            Producto productoActualizado = productoService.guardarProducto(producto);
            return ResponseEntity.ok(productoActualizado);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/producto/deleteById/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        Optional<Producto> ObtenerProductoExiste = productoService.ObtenerProducto(id);
        if (ObtenerProductoExiste.isPresent()){
            productoService.eliminarProducto(ObtenerProductoExiste.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
