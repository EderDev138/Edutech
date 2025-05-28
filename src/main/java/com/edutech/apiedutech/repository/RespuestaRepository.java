package com.edutech.apiedutech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Respuesta;

public interface RespuestaRepository extends JpaRepository <Respuesta, Integer>{
    List <Respuesta> finByUsuarioId(int usuarioId);
}
