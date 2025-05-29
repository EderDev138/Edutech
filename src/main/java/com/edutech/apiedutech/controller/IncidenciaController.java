package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.service.IncidenciaService;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    IncidenciaService incidenciaService;

    @GetMapping
    public List<Incidencia> listarIncidencias(){
        return incidenciaService.listar();
    }


}
