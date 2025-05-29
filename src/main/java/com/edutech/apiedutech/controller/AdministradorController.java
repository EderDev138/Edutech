package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Administrador;
import com.edutech.apiedutech.service.AdministradorService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public String crearAdmin(@RequestBody Administrador admin){
        return administradorService.agregarAdmin(admin);
    }

    @PostMapping("/eliminar/Profesor/{id}")
    public String eliminarProfesor(@PathVariable String id){
        return administradorService.eliminarProfesor(id);
    }
    @PostMapping("/eliminar/Administrador/{id}")
    public String eliminarAdmin(@PathVariable String id){
        return administradorService.eliminarAdministrador(id);
    }
    @PostMapping("/eliminar/Usuario/{id}")
    public String eliminarUsuario(@PathVariable String id){
        return administradorService.eliminarProfesor(id);
    }

    @GetMapping
    public List<Administrador> listarAdmin(){
        return administradorService.listar();
    }
    



}
