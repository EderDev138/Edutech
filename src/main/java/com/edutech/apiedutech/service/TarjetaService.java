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
    if (tarjeta == null) {
        throw new IllegalArgumentException("Los datos de la tarjeta no pueden ser nulos.");
    }

    if (usuario == null || usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
        throw new IllegalArgumentException("El nombre del usuario es obligatorio.");
    }

    if (tarjeta.getNumeroTarjeta() == null || tarjeta.getNumeroTarjeta().isEmpty()) {
        throw new IllegalArgumentException("El número de tarjeta es obligatorio.");
    }

    if (tarjeta.getTitular() == null || tarjeta.getTitular().isEmpty()) {
        throw new IllegalArgumentException("El nombre del titular de la tarjeta es obligatorio.");
    }

    if (!tarjeta.getTitular().equalsIgnoreCase(usuario.getNombre())) {
        throw new IllegalArgumentException("El titular de la tarjeta debe coincidir con el nombre del alumno.");
    }

    return tarjetaRepository.save(tarjeta);
}

// Agregar una nueva tarjeta
public String agregarTarjeta(Tarjeta tarjeta) {
    if (tarjeta.getNumeroTarjeta() == null || tarjeta.getNumeroTarjeta().isEmpty()) {
        return "El número de tarjeta es obligatorio.";
    }
    if (tarjeta.getTitular() == null || tarjeta.getTitular().isEmpty()) {
        return "El titular de la tarjeta es obligatorio.";
    }
    tarjetaRepository.save(tarjeta);
    return "Tarjeta registrada exitosamente.";
}

// Eliminar tarjeta por ID
public String eliminarTarjeta(int id) {
    if (!tarjetaRepository.existsById(id)) {
        return "La tarjeta no existe.";
    }
    tarjetaRepository.deleteById(id);
    return "Tarjeta eliminada exitosamente.";
}

   



}
