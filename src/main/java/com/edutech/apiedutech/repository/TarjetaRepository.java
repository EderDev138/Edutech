package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
    // Aquí puedes agregar métodos personalizados si es necesario


}
