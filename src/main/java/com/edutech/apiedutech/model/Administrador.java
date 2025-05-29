package com.edutech.apiedutech.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Administrador {
    @Id
    private String email;
    private String nombre;
    private String contrasena;

    @OneToMany(mappedBy = "tecnico")
    private List<Incidencia> incidenciasAsignadas;

    public Administrador(){
        this.email = "";
        this.nombre = "";
        this.contrasena = "";
    }


    public List<Incidencia> getIncidenciasAsignadas() {
        return incidenciasAsignadas;
    }


    public void setIncidenciasAsignadas(List<Incidencia> incidenciasAsignadas) {
        this.incidenciasAsignadas = incidenciasAsignadas;
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

    


}
