package com.edutech.apiedutech.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tarjeta {
    @Id
    public String id;
    public String numeroTarjeta;
    public String fechaExpiracion;
    public String cvv;
    public String titular;

    public Tarjeta() {
        this.id = "";
        this.numeroTarjeta = "";
        this.fechaExpiracion = "";
        this.cvv = "";
        this.titular = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    
}

