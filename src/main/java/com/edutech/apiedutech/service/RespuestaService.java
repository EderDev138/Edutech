package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.model.Respuesta;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.repository.RespuestaRepository;
// REALIZADO POR: DAYANA VEGA


@Service
public class RespuestaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public List <Pregunta> listar(){
        return preguntaRepository.findAll();
    }

    public Respuesta guardarRespuesta(Respuesta respuesta) {
        if (respuesta == null || respuesta.getPregunta() == null || respuesta.getPregunta().getId() == 0) {
            throw new IllegalArgumentException("Debe asociar una pregunta válida.");
        }

        boolean preguntaExiste = preguntaRepository.existsById(respuesta.getPregunta().getId());

        if (!preguntaExiste) {
            throw new IllegalArgumentException("La pregunta asociada no existe.");
        }

        return respuestaRepository.save(respuesta);
    }


    public String eliminarRespuesta(int id) {
        if (!respuestaRepository.existsById(id)) {
            return "La respuesta con ID " + id + " no existe.";
        }

        respuestaRepository.deleteById(id);
        return "Respuesta con ID " + id + " eliminada exitosamente.";
    }

}