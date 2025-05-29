package com.edutech.apiedutech.dto;

// REALIZADO POR: ENCAR PORTILLO

public class AdministradorDTO {

    private String email;
    private String nombre;
    public AdministradorDTO(){
    this.email="";
    this.nombre="";

    }

    public AdministradorDTO(String email, String nombre, String contrasena) {
        this.email = email;
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
