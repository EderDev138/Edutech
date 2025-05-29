package com.edutech.apiedutech.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.dto.AsignacionProfesorDTO;
import com.edutech.apiedutech.dto.ProfesorDTO;
import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.service.ProfesorService;



@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping()
    public String almacenar(@RequestBody Profesor profesor) {
        if (profesor.getRut() == null || profesor.getRut().isEmpty()) {
            return "El RUT del profesor es obligatorio.";
        }
        
        return profesorService.registrarProfesor(profesor);
    }
    
    // asignar curso a profesor por url
    @PostMapping("/asignarcurso/{rut}/{sigla}")	
    public String asignarCurso(@PathVariable String rut, @PathVariable String sigla) {
            return profesorService.asignarCurso(rut, sigla);
    }
    // asignar curso a profesor por RUT y sigla por body con dto
    @PostMapping("/asignarcurso")
    public String asignarCurso(@RequestBody AsignacionProfesorDTO dto) {
    return profesorService.asignarCurso(dto.getRut(), dto.getSigla());
}
    // listar profesores con cursos
    @GetMapping()
    public List<Profesor> listar() {
        return profesorService.listar();
    }

    //listar profesores con DTO
    @GetMapping("/listar")
    public List<ProfesorDTO> listarProfesorDTO() {
    return profesorService.listar().stream().map(profesor -> {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setRut(profesor.getRut());
        dto.setNombre(profesor.getNombre());
        dto.setCursos(
            profesor.getCursos().stream()
                .map(Curso::getSigla)
                .collect(Collectors.toList())
        );
        return dto;
    }).collect(Collectors.toList());
    }
    
  

    
    
    }
    





