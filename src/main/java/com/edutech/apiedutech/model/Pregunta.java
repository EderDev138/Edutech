package com.edutech.apiedutech.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/** 
@author "Dayana Vega"
*/
// REALIZADO POR: DAYANA VEGA

@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private List<String> opciones = new ArrayList<>();

    private String siglaPregunta;
    private String enunciado;
    private String respuestaCorrecta;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", nullable = true)
    @JsonBackReference
    private Evaluacion evaluacion;

    public Pregunta() {
        this.siglaPregunta = "";
        this.enunciado = "";
        this.opciones = new ArrayList<>();
        this.respuestaCorrecta = "";
    }


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

    public String getSiglaPregunta() {
        return siglaPregunta;
    }

    public void setSiglaPregunta(String siglaPregunta) {
        this.siglaPregunta = siglaPregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    
}
