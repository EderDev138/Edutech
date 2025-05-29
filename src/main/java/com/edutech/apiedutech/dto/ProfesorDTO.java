package com.edutech.apiedutech.dto;

import java.util.List;
// REALIZADO POR: EDER VALDIVIA

public class ProfesorDTO {
    private String rut;
    private String nombre;
    private List<String> cursos;


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
    public List<String> getCursos() {
        return cursos;
    }
    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    
}
