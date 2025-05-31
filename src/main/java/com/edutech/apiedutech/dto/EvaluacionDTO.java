package com.edutech.apiedutech.dto;

import java.time.LocalDateTime;
// REALIZADO POR: DAYANA VEGA
import java.util.List;

public class EvaluacionDTO {
    private String sigla;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<PreguntaDTO> preguntas;



    public EvaluacionDTO(){
    }



    public EvaluacionDTO(String sigla, String titulo, String descripcion, LocalDateTime fechaInicio,
            LocalDateTime fechaFin, List<PreguntaDTO> preguntas) {
        this.sigla = sigla;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.preguntas = preguntas;
    }



    public String getSigla() {
        return sigla;
    }



    public void setSigla(String sigla) {
        this.sigla = sigla;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }



    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }



    public LocalDateTime getFechaFin() {
        return fechaFin;
    }



    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }



    public List<PreguntaDTO> getPreguntas() {
        return preguntas;
    }



    public void setPreguntas(List<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }

    


}
