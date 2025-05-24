package com.edutech.apiedutech.dto;

public class UsuarioDTO {
    private String rut;
    private String nombre;
    private String apellido;

    public UsuarioDTO(){
        this.rut = "" ;
        this.apellido = "";
        this.nombre = "";
        
    }

    public UsuarioDTO(String apellido, String nombre, String rut) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.rut = rut;
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


    
}
