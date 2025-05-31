package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Pregunta;
// REALIZADO POR: DAYANA VEGA


public interface PreguntaRepository extends JpaRepository <Pregunta, Integer> {

    Pregunta findBySiglaPregunta(String siglaPregunta);

}
