package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.repository.RespuestaRepository;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List <Pregunta> listar(){
        return preguntaRepository.findAll();
    }
    
    
}