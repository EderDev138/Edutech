package com.edutech.apiedutech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Profesor {
    @Id
    private String rut;
    private String email;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String estado;
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinTable(
        name= "profesores_cursos",
        joinColumns=@JoinColumn(name= "profesor_id",referencedColumnName= "rut"),
        inverseJoinColumns= @JoinColumn(name= "curso_id",referencedColumnName= "sigla")
    )
    
    @JsonBackReference
    private List<Curso> cursos;

    public Profesor() {
        this.rut = "";
        this.email = "";
        this.contrasena = "";
        this.nombre = "";
        this.apellido = "";
        this.estado = "";
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    
}
