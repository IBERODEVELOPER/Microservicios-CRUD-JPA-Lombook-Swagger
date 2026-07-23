package com.ibero.JPAsesionTwo.service.impl;

import com.ibero.JPAsesionTwo.entity.Producto;
import com.ibero.JPAsesionTwo.repository.ProductoRepository;
import com.ibero.JPAsesionTwo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> ObtenerProducto(Long Id) {
        return productoRepository.findById(Id);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long Id) {
    productoRepository.deleteById(Id);
    }
}
