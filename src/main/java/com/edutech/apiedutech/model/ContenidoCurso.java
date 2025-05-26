package com.edutech.apiedutech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ContenidoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String urlcurso;

    @ManyToOne
    @JoinColumn(name = "curso_sigla")
    private Curso curso;

    public  ContenidoCurso(){
        this.id = (long) 0;
        this.titulo = "";
        this.descripcion = "";
        this.urlcurso = "";
    }

    public ContenidoCurso(Long id, String titulo, String descripcion, String urlcurso, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlcurso = urlcurso;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUrlcurso() {
        return urlcurso;
    }

    public void setUrlcurso(String urlcurso) {
        this.urlcurso = urlcurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    

    

}
