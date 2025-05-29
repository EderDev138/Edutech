package com.edutech.apiedutech.dto;

public class AdministradorDTO {

    private String email;
    private String nombre;
    private String contrasena;

    public AdministradorDTO(){
    this.email="";
    this.nombre="";
    this.contrasena="";

    }

    public AdministradorDTO(String email, String nombre, String contrasena) {
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    

}
