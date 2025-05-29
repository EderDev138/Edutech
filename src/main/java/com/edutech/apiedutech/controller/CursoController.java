package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.service.CursoService;
// REALIZADO POR: EDER VALDIVIA
@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public String almacenar(@RequestBody Curso curso) {
        return cursoService.almacenar(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @PostMapping("/contenido/{sigla}/{id}")
    public String asignarContenido(@PathVariable String sigla, @PathVariable Long id){
        return cursoService.asignarContenido(sigla, id);

    }

    @DeleteMapping("/{sigla}")
    public String eliminar(@PathVariable String sigla) {
        return cursoService.eliminar(sigla);
    }

    @PutMapping("/{sigla}")
    public String actualizar(@PathVariable String sigla, @RequestBody Curso curso) {
        return cursoService.actualizar(sigla, curso);
    }

}