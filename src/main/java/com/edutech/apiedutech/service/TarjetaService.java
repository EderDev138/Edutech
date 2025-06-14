package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Tarjeta;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.repository.TarjetaRepository;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

  

    public Tarjeta validarTarjeta(Tarjeta tarjeta, Usuario usuario) {
    if (tarjeta.getNumeroTarjeta() == null || tarjeta.getNumeroTarjeta().isEmpty()) {
        throw new IllegalArgumentException("El número de tarjeta es obligatorio.");
    }
    if (!tarjeta.getTitular().equalsIgnoreCase(usuario.getNombre())) {
        throw new IllegalArgumentException("El titular de la tarjeta debe coincidir con el nombre del alumno.");
    }
    return tarjetaRepository.save(tarjeta);
}
   



}
