package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.dto.ActualizarIncidenciaDTO;
import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.service.IncidenciaService;


@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    IncidenciaService incidenciaService;

    @GetMapping()
    public List<Incidencia> listarIncidencias(){
        return incidenciaService.listar();
    }

    @PostMapping()
    public String crearIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaService.crearIncidencia(incidencia);
    }

    @GetMapping("/{id}")    
    public Incidencia encontrarIncidencia(@PathVariable Long id) {
        return incidenciaService.encontrarIncidencia(id);

    }   
    @PostMapping("/actualizar/{id}")
    public String actualizarIncidencia(@PathVariable Long id, @RequestBody ActualizarIncidenciaDTO nvaIncidencia) {
        return incidenciaService.actualizaIncidencia(id, nvaIncidencia);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarIncidencia(Long id) {
        return incidenciaService.eliminarIncidencia(id);
    }

}
