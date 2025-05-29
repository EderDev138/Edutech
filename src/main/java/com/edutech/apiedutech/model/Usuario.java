package com.edutech.apiedutech.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

/** 
@author "Eder Valdivia"
*/
@Entity
public class Usuario {
    @Id
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinTable(
        name= "usuarios_cursos",
        joinColumns=@JoinColumn(name= "usuario_rut",referencedColumnName= "rut"),
        inverseJoinColumns= @JoinColumn(name= "curso_id",referencedColumnName= "sigla")
    )
    @JsonBackReference
    private List<Curso> cursos;


    @OneToMany(mappedBy = "usuario")
    private List<Incidencia> incidenciasReportadas;


    public Usuario() {
        this.rut = "";
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.contrasena = "";
        this.cursos = new ArrayList<>();
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public List<Incidencia> getIncidenciasReportadas() {
        return incidenciasReportadas;
    }

    public void setIncidenciasReportadas(List<Incidencia> incidenciasReportadas) {
        this.incidenciasReportadas = incidenciasReportadas;
    }
    
    
    }
