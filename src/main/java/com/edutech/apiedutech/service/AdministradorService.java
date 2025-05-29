package com.edutech.apiedutech.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.AdministradorDTO;
import com.edutech.apiedutech.model.Administrador;
import com.edutech.apiedutech.model.Profesor;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.repository.AdministradorRepository;
import com.edutech.apiedutech.repository.ProfesorRepository;
import com.edutech.apiedutech.repository.UsuarioRepository;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public String agregarAdmin(Administrador administrador){
        if(administradorRepository.existsById(administrador.getEmail())){
            return "Email para administrador ya existe, por favor use otro";
        }else{
            administradorRepository.save(administrador);
            return "Administrador agregado exitosamente";
        }
    }

    public String eliminarAdministrador(String id){
        if (!administradorRepository.existsById(id)){
            return "Usuario no existe";
        }else {
            Administrador admin = administradorRepository.findById(id).get();
            administradorRepository.deleteById(id);
            return "Usuario "+admin.getNombre()+" eliminado";
        }
        }


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

    public List<AdministradorDTO> listar(){
        return administradorRepository.findAll().stream().map(admin ->{
            AdministradorDTO admindto = new AdministradorDTO();
            admindto.setEmail(admin.getEmail());
            admindto.setNombre(admin.getNombre());
            return admindto;
        }).collect(Collectors.toList());
        
    }


}
