package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Pregunta;
import java.util.List;


public interface PreguntaRepository extends JpaRepository <Pregunta, Integer> {
    List<Pregunta> findById(int evaluacionId);
}
