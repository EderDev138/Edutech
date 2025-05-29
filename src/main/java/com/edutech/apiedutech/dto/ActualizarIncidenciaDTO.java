package com.edutech.apiedutech.dto;

import java.time.LocalDateTime;

public class ActualizarIncidenciaDTO {

    private String comentario;
    private LocalDateTime fechaActualizacion;
    private String estado;

    public ActualizarIncidenciaDTO(){}

    public ActualizarIncidenciaDTO(String comentario, LocalDateTime fechaActualizacion, String estado) {
        this.comentario = comentario;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
