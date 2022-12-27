package com.example.drogueria.repository;

import com.example.drogueria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.drogueria.repository.crudrepository.ClienteCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAllClientes(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getCliente(Integer id){
        return clienteCrudRepository.findById(id);
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }
    public boolean deleteCliente(Integer id){
        clienteCrudRepository.deleteById(id);
        return true;
    }
    public Cliente updateCliente(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }


}
