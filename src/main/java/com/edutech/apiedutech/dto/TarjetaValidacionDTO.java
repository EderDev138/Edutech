package com.edutech.apiedutech.dto;

import com.edutech.apiedutech.model.Tarjeta;
import com.edutech.apiedutech.model.Usuario;

public class TarjetaValidacionDTO {


    private Tarjeta tarjeta;
    private Usuario usuario;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
