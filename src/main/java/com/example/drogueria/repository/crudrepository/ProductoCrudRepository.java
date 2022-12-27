package com.example.drogueria.repository.crudrepository;

import com.example.drogueria.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
