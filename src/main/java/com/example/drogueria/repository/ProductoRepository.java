package com.example.drogueria.repository;

import com.example.drogueria.model.Producto;
import com.example.drogueria.repository.crudrepository.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAllProductos(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Optional<Producto> getProducto(Integer id){
        return productoCrudRepository.findById(id);
    }

    public Producto saveProducto(Producto producto){
        return productoCrudRepository.save(producto);
    }
    public boolean deleteProducto(Integer id){
        productoCrudRepository.deleteById(id);
        return true;
    }
    public Producto updateProducto(Producto producto){
        return productoCrudRepository.save(producto);
    }

}
