package com.edutech.apiedutech.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private String cantidadDescuento;

    private LocalDate fechaExpiracion;
    private LocalDate fechaUso;

    private Boolean usado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;



}
