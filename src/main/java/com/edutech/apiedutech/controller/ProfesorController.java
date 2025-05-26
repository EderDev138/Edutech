package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping()
    public List<Profesor> listar(@RequestParam Profesor profesor) {
        return profesorService.listarProfesor();
    }
    
    





}
