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

import com.edutech.apiedutech.dto.ActualizarIncidenciaDTO;
import com.edutech.apiedutech.dto.AdministradorIncidenciaDTO;
import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.service.IncidenciaService;

// REALIZADO POR: ENCAR PORTILLO

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

    @DeleteMapping("/eliminar/{id}")
    public String eliminarIncidencia(@PathVariable Long id) {
        return incidenciaService.eliminarIncidencia(id);
    }

    @PostMapping("/asignar")
    public String asignarIncidencia(@RequestBody AdministradorIncidenciaDTO dto){
        return incidenciaService.asignarIncidencia(dto);

    }


}
