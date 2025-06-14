package com.edutech.apiedutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.apiedutech.dto.AsignacionUsuarioDTO;
import com.edutech.apiedutech.dto.UsuarioDTO;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.service.UsuarioService;
// REALIZADO POR: EDER VALDIVIA

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;    
    
    @PostMapping()
    public String almacenar(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping()
    public List<Usuario> listar() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarioDTO() {
        return usuarioService.listarUsuario().stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setRut(usuario.getRut());
            dto.setNombre(usuario.getNombre());
            dto.setApellido(usuario.getApellido());
            return dto;
        }).toList();
    }

    @DeleteMapping("/eliminar/{rut}")
    public String eliminarUsuario(String rut) {
        return usuarioService.eliminarUsuario(rut);
    }
    // se asigna por body
   @PostMapping("/asignarcurso")
    public String asignarCurso(@RequestBody AsignacionUsuarioDTO dto) {
    return usuarioService.inscripcion(dto.getRut(), dto.getSigla());
}
}