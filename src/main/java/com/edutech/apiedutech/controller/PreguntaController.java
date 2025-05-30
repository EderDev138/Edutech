package com.edutech.apiedutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPregunta(@PathVariable int id) {
        return preguntaService.eliminarPregunta(id);
    }

    @GetMapping("/listar")
    public String listarPreguntas() {
        return preguntaService.listar().toString();
    }
}
