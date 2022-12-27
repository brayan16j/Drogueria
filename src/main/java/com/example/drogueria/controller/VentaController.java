package com.example.drogueria.controller;

import com.example.drogueria.model.VentaProducto;
import com.example.drogueria.service.VentaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaController {

    @Autowired
    private VentaProductoService ventaProductoService;

    @GetMapping("/all")
    public List<VentaProducto> getAllVentas(){
        return ventaProductoService.getAllVentas();
    }
    @GetMapping("{id}")
    public Optional<VentaProducto> getVenta(@PathVariable("id")Integer id){
        return ventaProductoService.getVenta(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public VentaProducto saveVenta(@RequestBody VentaProducto ventaProducto){
        return ventaProductoService.saveVenta(ventaProducto);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public VentaProducto updateVenta(@RequestBody VentaProducto ventaProducto){
        return ventaProductoService.updateVenta(ventaProducto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteVenta(@PathVariable("id")Integer id){
        return ventaProductoService.deleteVenta(id);
    }
}
