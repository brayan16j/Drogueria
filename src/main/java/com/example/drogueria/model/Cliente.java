package com.example.drogueria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer cedula;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cliente")
    @JsonIgnoreProperties("cliente")
    public List<Producto> productos;

    @OneToOne
    @JsonIgnoreProperties("cliente")
    private VentaProducto ventaProducto;

}
