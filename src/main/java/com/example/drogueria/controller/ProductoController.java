package com.example.drogueria.controller;

import com.example.drogueria.model.Producto;
import com.example.drogueria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("{id}")
    public Optional<Producto> getProducto(@PathVariable("id")Integer id){
        return productoService.getProducto(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto updateProducto(@RequestBody Producto producto){
        return productoService.updateProducto(producto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProducto(@PathVariable("id") Integer id){
        return productoService.deleteProducto(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto saveProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

}
