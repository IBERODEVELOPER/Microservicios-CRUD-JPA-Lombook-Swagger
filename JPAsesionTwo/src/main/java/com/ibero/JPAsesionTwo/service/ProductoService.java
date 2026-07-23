package com.ibero.JPAsesionTwo.service;


import com.ibero.JPAsesionTwo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listarProducto();
    Optional<Producto> ObtenerProducto(Long Id);
    Producto guardarProducto(Producto producto);
    void eliminarProducto(Long Id);

}
