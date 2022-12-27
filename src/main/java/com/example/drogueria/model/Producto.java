package com.example.drogueria.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@Getter
@Setter
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer stock;
    private Integer stockMinimo;
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    @JsonIgnoreProperties({"producto"})
    private Cliente cliente;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "producto")
    @JsonIgnoreProperties("producto")
    public List<VentaProducto> ventaProductos;
}
