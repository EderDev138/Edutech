package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.dto.PreguntaDTO;
import com.edutech.apiedutech.model.Pregunta;
import com.edutech.apiedutech.service.PreguntaService;

// REALIZADO POR: DAYANA VEGA

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @PostMapping
    public String crearPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.guardarPregunta(pregunta);


    }
    
    @DeleteMapping("/eliminar/{sigla}")
    public String eliminarPregunta(@PathVariable String sigla) {
        return preguntaService.eliminarPregunta(sigla);
    }

    @GetMapping("/listar")
    public List<PreguntaDTO> listarPreguntas() {
        return preguntaService.listar();
    }

    @GetMapping("/preguntas/{sigla}")
    public ResponseEntity<?> obtenerPreguntaPorSigla(@PathVariable String sigla) {
    return preguntaService.mostrarPreguntaPorSigla(sigla);
}

}
