package com.example.drogueria.service;
import com.example.drogueria.model.Producto;
import com.example.drogueria.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.getAllProductos();
    }

    public Optional<Producto> getProducto(Integer id){
        return productoRepository.getProducto(id);
    }

    public Producto saveProducto(Producto producto){
        if(producto.getId()==null){
            return productoRepository.saveProducto(producto);
        }else {
            Optional<Producto> clienteEncontrado = getProducto(producto.getId());
            if(clienteEncontrado.isEmpty()){
                return productoRepository.saveProducto(producto);
            }else {
                return producto;
            }
        }
    }
    public boolean deleteProducto(Integer id){
        Boolean respuesta = getProducto(id).map(e ->{
            productoRepository.deleteProducto(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }

    public Producto updateProducto(Producto producto){
        if (producto.getId()!=null) {
            Optional<Producto> productoEncontrado = getProducto(producto.getId());
            if (!productoEncontrado.isEmpty()) {
                if (producto.getNombre() != null) {
                    productoEncontrado.get().setNombre(producto.getNombre());
                }
                if (producto.getTipo() != null) {
                    productoEncontrado.get().setTipo(producto.getTipo());
                }
                if (producto.getStock() != null) {
                    productoEncontrado.get().setStock(producto.getStock());
                }
                if (producto.getStockMinimo() != null) {
                    productoEncontrado.get().setStockMinimo(producto.getStockMinimo());
                }
                if (producto.getPrecio() != null) {
                    productoEncontrado.get().setPrecio(producto.getPrecio());
                }
                return productoRepository.saveProducto(productoEncontrado.get());
            }
        }
        return producto;
    }
}
