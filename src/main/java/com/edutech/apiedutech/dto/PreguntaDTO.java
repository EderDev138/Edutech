package com.edutech.apiedutech.dto;
// REALIZADO POR: DAYANA VEGA

import java.util.List;

public class PreguntaDTO {
     private String sigla;
     private String enunciado;
     private List<String> opciones;

    public PreguntaDTO(){
    }

    public PreguntaDTO(String sigla, String enunciado, List<String> opciones) {
        this.sigla = sigla;
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    


     
    

     
}
