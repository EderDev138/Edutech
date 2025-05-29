package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.repository.ProfesorRepository;
import com.edutech.apiedutech.repository.UsuarioRepository;

@Service
public class AdministradorService {


    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public String eliminarUsuario(String id){
        if (!usuarioRepository.existsById(id)){
            return "Usuario no existe";
        }else {
            Usuario usuario = usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
            return "Usuario "+usuario.getNombre()+" eliminado";
        }
        }
    
    public String eliminarProfesor(String id){
        if (!profesorRepository.existsById(id)){
            return "Profesor no existe";
        }else {
            Profesor profesor = profesorRepository.findById(id).get();
            profesorRepository.deleteById(id);
            return "Profesor "+profesor.getNombre()+" eliminado";
        }
        }


    }
