package com.edutech.apiedutech.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

/** 
@author "Encar Portillo";
*/
// REALIZADO POR: ENCAR PORTILLO
@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private String estado;
    private LocalDateTime fechaSolucion;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "rut", nullable = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tecnico_asignado", referencedColumnName = "email", nullable = true)
    private Administrador tecnico;

    @ManyToOne
    @JoinColumn(name = "curso_relacionado", referencedColumnName = "sigla", nullable = true)
    private Curso curso;

    public Incidencia(){
    }

    @PrePersist
    protected void fechaAuto(){
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(LocalDateTime fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Administrador getTecnico() {
        return tecnico;
    }

    public void setTecnico(Administrador tecnico) {
        this.tecnico = tecnico;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    


}
