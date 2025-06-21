package com.edutech.apiedutech.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
/** 
@author "Eder Valdivia"
*/
// REALIZADO POR: EDER VALDIVIA

@Entity
public class Curso {
    @Id
    private String sigla;
    private String nombre;
    private String descripcion;

     @ManyToMany(mappedBy="cursos")
    
    private List<Usuario> usuarios;
    @ManyToMany(mappedBy="cursos")
 
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContenidoCurso> contenidoCurso;

    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
    private List<Incidencia> incidenciasRelacionadas;

    @ManyToOne
    @JoinColumn(name = "codigo_cupon")
    private Cupon cupon;

    
   
    public Curso() {   
        this.sigla = "";
        this.nombre = "";
        this.descripcion = "";
    }

     public Curso(String sigla, String nombre, String descripcion, List<Usuario> usuarios) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }
    public Curso(String sigla, String nombre, String descripcion) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<ContenidoCurso> getContenidoCurso() {
        return contenidoCurso;
    }

    public void setContenidoCurso(List<ContenidoCurso> contenidoCurso) {
        this.contenidoCurso = contenidoCurso;
    }

    public List<Incidencia> getIncidenciasRelacionadas() {
        return incidenciasRelacionadas;
    }

    public void setIncidenciasRelacionadas(List<Incidencia> incidenciasRelacionadas) {
        this.incidenciasRelacionadas = incidenciasRelacionadas;
    }

    
    
}
