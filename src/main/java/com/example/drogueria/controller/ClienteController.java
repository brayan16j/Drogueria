package com.example.drogueria.controller;

import com.example.drogueria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.drogueria.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }
    @GetMapping("{id}")
    public Optional<Cliente> getCliente(@PathVariable("id")Integer id){
        return clienteService.getCliente(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable("id") Integer id){
        return clienteService.deleteCliente(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente){
        return clienteService.updateCliente(cliente);
    }
}


