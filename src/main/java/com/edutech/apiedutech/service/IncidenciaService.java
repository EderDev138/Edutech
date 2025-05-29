package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.ActualizarIncidenciaDTO;
import com.edutech.apiedutech.dto.AdministradorIncidenciaDTO;
import com.edutech.apiedutech.model.Administrador;
import com.edutech.apiedutech.model.Incidencia;
import com.edutech.apiedutech.repository.AdministradorRepository;
import com.edutech.apiedutech.repository.IncidenciaRepository;


@Service
public class IncidenciaService {

    @Autowired
    IncidenciaRepository incidenciaRepository;

    @Autowired
    AdministradorRepository administradorRepository;

    public String crearIncidencia(Incidencia incidencia){
        incidenciaRepository.save(incidencia);
        return "Incidencia guardada";
    }

    public Incidencia encontrarIncidencia(Long id){
        if(!incidenciaRepository.existsById(id)){
            throw new RuntimeException("Incidencia no existe") ;
        }else{
            Incidencia incidencia = incidenciaRepository.findById(id).get();
            return incidencia;
        }
    }

    public List<Incidencia> listar(){
        return incidenciaRepository.findAll();
    }

    public String actualizaIncidencia(Long id, ActualizarIncidenciaDTO nvaIncidencia){
        if(!incidenciaRepository.existsById(id)){
            return "No existe incidencia para actualizar";
        }else{
            Incidencia incidencia = incidenciaRepository.findById(id).get();
            incidencia.setComentario(nvaIncidencia.getComentario());
            incidencia.setEstado(nvaIncidencia.getEstado());
            incidencia.setFechaSolucion(nvaIncidencia.getFechaActualizacion());
            incidenciaRepository.save(incidencia);
            return "Incidencia con id: " +incidencia.getId() +" Actualizada";
        }
    }

    public String eliminarIncidencia(Long id){
        if(!incidenciaRepository.existsById(id)){
            return "Incidencia no existe";
        }else{
            incidenciaRepository.deleteById(id);
            return "Incidencia eliminada";
        }
    }


        public String asignarIncidencia(String adminId, Long incidenciaId ){
        if(!administradorRepository.existsById(adminId)){
            return "El administrador no existe";
        }else if(!incidenciaRepository.existsById(incidenciaId)){
            return "La incidencia no existe";
        }else{
            Administrador admin = administradorRepository.findById(adminId).get();
            Incidencia incidencia = incidenciaRepository.findById(incidenciaId).get();
            
            incidencia.setTecnico(admin);
            incidenciaRepository.save(incidencia);

            return "Incidencia asignada correctamente";

        }
    }
        public String asignarIncidencia(AdministradorIncidenciaDTO admin){
        if(!administradorRepository.existsById(admin.getAdminId())){
            return "El administrador no existe";
        }else if(!incidenciaRepository.existsById(admin.getIncidenciaId())){
            return "La incidencia no existe";
        }else{
            Administrador adm = administradorRepository.findById(admin.getAdminId()).get();
            Incidencia incidencia = incidenciaRepository.findById(admin.getIncidenciaId()).get();
            
            incidencia.setTecnico(adm);
            incidenciaRepository.save(incidencia);

            return "Incidencia asignada correctamente";

        }
    }

}
