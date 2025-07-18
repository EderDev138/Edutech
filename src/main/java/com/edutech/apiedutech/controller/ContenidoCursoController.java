package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.service.ContenidoCursoService;

// REALIZADO POR: ENCAR PORTILLO

@RestController
@RequestMapping("/contenidos")
public class ContenidoCursoController {

    @Autowired
    private ContenidoCursoService contenidoCursoService;

    @GetMapping()
    public List<ContenidoCurso> listar(){
        return contenidoCursoService.listar();
    }


    @PostMapping()
    public String almacenarContenido(@RequestBody ContenidoCurso contenido){
        return contenidoCursoService.almacenarContenido(contenido);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarContenido(@PathVariable Long id){
        return contenidoCursoService.eliminarContenido(id);
    }

    

    

}
