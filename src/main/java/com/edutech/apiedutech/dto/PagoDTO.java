package com.edutech.apiedutech.dto;

import java.time.LocalDateTime;

// REALIZADO POR: DAYANA VEGA

public class PagoDTO {
    private int monto;
    private LocalDateTime fechaPago;
    private String estadoPago;
    public int getMonto() {
        return monto;
    }
    public void setMonto(int monto) {
        this.monto = monto;
    }
    public LocalDateTime getFechaPago() {
        return fechaPago;
    }
    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
    public String getEstadoPago() {
        return estadoPago;
    }
    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

   
    
}
