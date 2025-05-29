package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;

public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List <Pregunta> listar(){
        return preguntaRepository.findAll();

    }

    
}
