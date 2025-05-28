package com.edutech.apiedutech.dto;

public class RespuestaDTO {
    private int id;
    private int usuarioId;
    private int preguntaId;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public int getPreguntaId() {
        return preguntaId;
    }
    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    
}
