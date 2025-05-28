package com.edutech.apiedutech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int preguntaId;
    private int UsuarioId;
    private Boolean respuestaUsuario;
    private float puntaje;


    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "id_pregunta", nullable = false)
=======
    @JoinColumn(name = "pregunta_id", referencedColumnName="pregunta" )
>>>>>>> 64580dce6806ff50202bcbf336a5c6615c294fb2
    private Pregunta pregunta;

    public Respuesta(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        UsuarioId = usuarioId;
    }

    public Boolean getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(Boolean respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    
    }