package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List <Pregunta> listar(){
        return preguntaRepository.findAll();

    }

    public String eliminarPregunta(int id) {
        Pregunta pregunta = preguntaRepository.findById(id).orElse(null);

        if (pregunta != null) {
            preguntaRepository.delete(pregunta);
            return "Pregunta eliminada con éxito";
        } else {
            return "La pregunta no existe";
        }
    }

        

}

