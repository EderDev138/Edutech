package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;

@Service
public class RespuestaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List <Pregunta> listar(){
        return preguntaRepository.findAll();
    }
    
    public Pregunta buscarPorId(int id) {
        return preguntaRepository.findById(id).orElse(null);
    }
 public Pregunta guardarPregunta(Pregunta pregunta) {
    
    if (pregunta != null && pregunta.isCorrecta()) {
        return preguntaRepository.save(pregunta);
    } else {
       
        return null;
    }

}