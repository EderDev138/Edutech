package com.edutech.apiedutech.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/** 
@author "Dayana Vega"
*/
@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String enunciado;
    private String opciones;
    private String respuestaCorrecta;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", nullable = false)
    @JsonBackReference
    private Evaluacion evaluacion;

    public Pregunta() {
        this.enunciado = "";
        this.opciones = "";
        this.respuestaCorrecta = "";
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    
}
