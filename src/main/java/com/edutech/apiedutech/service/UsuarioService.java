package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.repository.CursoRepository;
import com.edutech.apiedutech.repository.UsuarioRepository;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;


  public String registrarUsuario(Usuario usuario) {
    if (usuarioRepository.findById(usuario.getRut()).isPresent()) {
        return "El usuario con rut " + usuario.getRut() + " ya existe.";
    }

    usuarioRepository.save(usuario);
    return "Usuario registrado exitosamente.";
    }

    
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public String inscripcion(String rut, String sigla){
        if(!cursoRepository.existsById(sigla)){
            return "El curso con sigla" + sigla +" no existe";
        }
        if(!usuarioRepository.existsById(rut)){
            return "Alumn@ con rut:" + rut + " no existe";
        }

        Curso curso = cursoRepository.findById(sigla).get();
        Usuario usuario = usuarioRepository.findById(rut).get();


        if(usuario.getCursos().contains(curso)){
            return "Usuario ya se encuentra registrado";
        } else{
            usuario.getCursos().add(curso);
            usuarioRepository.save(usuario);
            return "Usuario inscrito exitosamente";
        }
        
       
    }    
}
