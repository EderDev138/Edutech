package com.edutech.apiedutech.dto;

public class CrearProfesorDTO {

    private String rut;
    private String email;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String estado;

    public CrearProfesorDTO(){
        this.rut = "";
        this.email = "";
        this.contrasena = "";
        this.nombre = "";
        this.apellido = "";
        this.estado = "";
    }

    public CrearProfesorDTO(String rut, String email, String contrasena, String nombre, String apellido,
            String estado) {
        this.rut = rut;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
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

    

}
