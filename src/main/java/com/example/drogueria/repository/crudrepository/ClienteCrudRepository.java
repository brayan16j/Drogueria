package com.example.drogueria.repository.crudrepository;

import com.example.drogueria.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository <Cliente, Integer>  {
}
