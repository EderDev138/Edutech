package com.edutech.apiedutech.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/** 
@author "Encar Portillo"
*/
// REALIZADO POR: ENCAR PORTILLO
@Entity
public class Cupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String descripcion;

    private int cantidadDescuento;

    private LocalDate fechaExpiracion;
    private LocalDate fechaUso;

    private Boolean usado;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Curso> listaCursos;

    @OneToOne
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;

    public Cupon(){
     }
     

}
