package com.edutech.apiedutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.CursoDTO;
import com.edutech.apiedutech.dto.UsuarioDTO;
import com.edutech.apiedutech.model.ContenidoCurso;
import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.repository.ContenidoCursoRepository;
import com.edutech.apiedutech.repository.CursoRepository;
// REALIZADO POR: EDER VALDIVIA

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ContenidoCursoRepository contenidoCursoRepository;

    //almacenar sin dto
    public String almacenar(Curso curso) {
        if (cursoRepository.findById(curso.getSigla()).isPresent()) {
            return "El curso con sigla " + curso.getSigla() + " ya existe.";
        }

        cursoRepository.save(curso);
        return "Curso registrado exitosamente";
    }

   

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscar(String sigla) {
        return cursoRepository.findById(sigla).orElse(null);
    }

    public String asignarContenido(String sigla, Long id){
        if (!cursoRepository.existsById(sigla)){
            return "El curso no existe";
        }else if (!contenidoCursoRepository.existsById(id)){
            return "El contenido seleccionado no existe";
        }else{
            Curso curso = cursoRepository.findById(sigla).get();
            ContenidoCurso contenidoCurso = contenidoCursoRepository.findById(id).get();

            curso.getContenidoCurso().add(contenidoCurso);
            cursoRepository.save(curso);
            return "El contenido " + contenidoCurso.getTitulo() + " ha sido almacenado";
        }

    }

  public List<CursoDTO> listarCursos() {
    return cursoRepository.findAll().stream().map(curso -> {
        CursoDTO dto = new CursoDTO();
        dto.setSigla(curso.getSigla());
        dto.setNombre(curso.getNombre());

        List<UsuarioDTO> usuariosDTO = curso.getUsuarios().stream().map(usuario -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setRut(usuario.getRut());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setApellido(usuario.getApellido());
            // agrega más campos si es necesario
            return usuarioDTO;
        }).toList();
        dto.setUsuarios(usuariosDTO);
        return dto;
    }).toList();
}

    public String eliminar(String sigla) {
        if (cursoRepository.existsById(sigla)) {
            cursoRepository.deleteById(sigla);
            return "Curso eliminado exitosamente";
        } else {
            return "El curso con sigla " + sigla + " no existe.";
        }
    }

    public String actualizar(String sigla, Curso curso) {
        if (cursoRepository.existsById(sigla)) {
            curso.setSigla(sigla);
            cursoRepository.save(curso);
            return "Curso actualizado exitosamente";
        } else {
            return "El curso con sigla " + sigla + " no existe.";
        }
    }
}