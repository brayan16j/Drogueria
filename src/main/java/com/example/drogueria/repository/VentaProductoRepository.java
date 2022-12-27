package com.example.drogueria.repository;

import com.example.drogueria.model.VentaProducto;
import com.example.drogueria.repository.crudrepository.VentaProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VentaProductoRepository {

    @Autowired
    private VentaProductoCrudRepository ventaProductoCrudRepository;

    public List<VentaProducto> getAllVentas(){
        return (List<VentaProducto>) ventaProductoCrudRepository.findAll();
    }

    public Optional<VentaProducto> getVenta(Integer id){
        return ventaProductoCrudRepository.findById(id);
    }

    public VentaProducto saveVenta(VentaProducto ventaProducto){
        return ventaProductoCrudRepository.save(ventaProducto);
    }
    public boolean deleteVenta(Integer id){
        ventaProductoCrudRepository.deleteById(id);
        return true;
    }
    public VentaProducto updateVenta(VentaProducto ventaProducto){
        return ventaProductoCrudRepository.save(ventaProducto);
    }

}
