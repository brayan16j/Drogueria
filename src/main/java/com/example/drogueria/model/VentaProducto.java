package com.example.drogueria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@Getter
@Setter
public class VentaProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String valor;

    @OneToOne
    @JsonIgnoreProperties("venta")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "productoId")
    @JsonIgnoreProperties({"venta"})
    private Producto producto;

}
