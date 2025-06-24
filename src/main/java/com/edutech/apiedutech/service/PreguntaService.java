package com.edutech.apiedutech.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.PreguntaDTO;
import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.repository.PreguntaRepository;
// REALIZADO POR: DAYANA VEGA

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List <PreguntaDTO> listar(){
        return preguntaRepository.findAll().stream().map(pregunta ->{
        PreguntaDTO preguntadto = new PreguntaDTO();
        preguntadto.setSigla(pregunta.getSiglaPregunta());
        preguntadto.setEnunciado(pregunta.getEnunciado());
        preguntadto.setOpciones(pregunta.getOpciones());
        return preguntadto;
    }).collect(Collectors.toList());

    }

    public ResponseEntity<?> mostrarPreguntaPorSigla(String sigla) {
    Pregunta pregunta = preguntaRepository.findBySiglaPregunta(sigla);

    if (pregunta != null) {
        PreguntaDTO dto = new PreguntaDTO();
        dto.setSigla(pregunta.getSiglaPregunta());
        dto.setEnunciado(pregunta.getEnunciado());
        dto.setOpciones(pregunta.getOpciones());
        return ResponseEntity.ok(dto);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pregunta no encontrada");
    }
    }


    public String eliminarPregunta(String sigla) {
        Pregunta pregunta = preguntaRepository.findBySiglaPregunta(sigla);

        if (pregunta != null) {
            preguntaRepository.delete(pregunta);
            return "Pregunta eliminada con éxito";
        } else {
            return "La pregunta no existe";
        }
    }
    public String guardarPregunta(Pregunta pregunta) {
        if(preguntaRepository.findBySiglaPregunta(pregunta.getSiglaPregunta()) != null){
            return "La pregunta ya existe";
        }else{
            preguntaRepository.save(pregunta);
            return "Pregunta almacenada correctamente";
        }

    }
    
        

}

