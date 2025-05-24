package com.edutech.apiedutech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity

public class Usuario {
    @Id
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    @ManyToMany
    @JoinTable(
        name= "usuarios",
        joinColumns= @JoinColumn(name= "usuario_rut"),
        inverseJoinColumns= @JoinColumn(name= "curso_sigla")
    )
    @JsonBackReference
    private List<Curso> cursos;
    
    public Usuario(){
        this.rut = "";
        this.nombre = "";
        this.email = "";
        this.apellido = "";
        this.contrasena = "";
    }

    public Usuario(String rut, String nombre, String apellido, String email, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    }
