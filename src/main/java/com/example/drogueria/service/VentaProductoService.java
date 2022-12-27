package com.example.drogueria.service;

import com.example.drogueria.model.VentaProducto;
import com.example.drogueria.repository.VentaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaProductoService {

    @Autowired
    private VentaProductoRepository ventaProductoRepository;

    public List<VentaProducto> getAllVentas(){
        return ventaProductoRepository.getAllVentas();
    }

    public Optional<VentaProducto> getVenta(Integer id){
        return ventaProductoRepository.getVenta(id);
    }

    public VentaProducto saveVenta(VentaProducto ventaProducto){
        if(ventaProducto.getId()==null){
            return ventaProductoRepository.saveVenta(ventaProducto);
        }else{
            Optional<VentaProducto> ventaEncontrado = getVenta(ventaProducto.getId());
            if(ventaEncontrado.isEmpty()){
                return ventaProductoRepository.saveVenta(ventaProducto);
            }else {
                return ventaProducto;
            }
        }

    }
    public boolean deleteVenta(Integer id){
        Boolean respuesta = getVenta(id).map(e ->{
            ventaProductoRepository.deleteVenta(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }

    public VentaProducto updateVenta (VentaProducto ventaProducto){
        if(ventaProducto.getId()!=null){
            Optional<VentaProducto> ventaProductoEncontrado = getVenta(ventaProducto.getId());
            if(!ventaProductoEncontrado.isEmpty()){
                if(ventaProducto.getValor()!= null){
                    ventaProductoEncontrado.get().setValor(ventaProducto.getValor());
                }
                if (ventaProducto.getProducto()!=null){
                    ventaProductoEncontrado.get().setProducto(ventaProducto.getProducto());
                }
                if(ventaProducto.getCliente()!=null){
                    ventaProductoEncontrado.get().setCliente(ventaProducto.getCliente());
                }
                return ventaProductoRepository.saveVenta(ventaProductoEncontrado.get());
            }
        }
        return ventaProducto;
    }
}
