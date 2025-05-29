package com.edutech.apiedutech.dto;

public class AdministradorDTO {

    private Long id;
    private String email;
    private String nombre;
    private String contrasena;

    public AdministradorDTO(){
    this.id=(long) 0;
    this.email="";
    this.nombre="";
    this.contrasena="";

    }

    public AdministradorDTO(Long id, String email, String nombre, String contrasena) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
