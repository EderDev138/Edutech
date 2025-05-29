package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.model.Respuesta;
import com.edutech.apiedutech.repository.PreguntaRepository;
import com.edutech.apiedutech.repository.RespuestaRepository;


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
        return respuestaRepository.save(respuesta);
    }    

    public String eliminarRespuesta(int id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElse(null);

        if (respuesta != null) {
            respuestaRepository.delete(respuesta);
            return "Respuesta eliminada con éxito";
        } else {
            return "La respuesta no existe";
        }
    }
}