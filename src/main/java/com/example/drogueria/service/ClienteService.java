package com.example.drogueria.service;

import com.example.drogueria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.drogueria.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.getAllClientes();
    }

    public Optional<Cliente>getCliente(Integer id){
        return clienteRepository.getCliente(id);
    }

    public Cliente saveCliente(Cliente cliente){
        if(cliente.getId()==null){
            return clienteRepository.saveCliente(cliente);
        }else {
            Optional<Cliente> clienteEncontrado = getCliente(cliente.getId());
            if(clienteEncontrado.isEmpty()){
                return clienteRepository.saveCliente(cliente);
            }else {
                return cliente;
            }
        }
    }
    public boolean deleteCliente(Integer id){
        Boolean respuesta = getCliente(id).map(e ->{
            clienteRepository.deleteCliente(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }

    public Cliente updateCliente(Cliente cliente){
        if (cliente.getId()!=null) {
            Optional<Cliente> clienteEncontrado = getCliente(cliente.getId());
            if (!clienteEncontrado.isEmpty()) {
                if (cliente.getNombre() != null) {
                    clienteEncontrado.get().setNombre(cliente.getNombre());
                }
                if (cliente.getCedula() != null) {
                    clienteEncontrado.get().setCedula(cliente.getCedula());
                }
                return clienteRepository.saveCliente(clienteEncontrado.get());
            }
        }
        return cliente;
    }


}
