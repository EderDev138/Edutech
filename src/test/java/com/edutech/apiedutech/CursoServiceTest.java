package com.edutech.apiedutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.apiedutech.dto.CursoDTO;
import com.edutech.apiedutech.model.Curso;
import com.edutech.apiedutech.model.Usuario;
import com.edutech.apiedutech.repository.CursoRepository;
import com.edutech.apiedutech.service.CursoService;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;


    @Test
    void almacenarCursoNuevo(){
        Curso curso = new Curso();
        curso.setSigla("BBDD002");

        when(cursoRepository.findById(curso.getSigla())).thenReturn(Optional.empty());

        String resultado = cursoService.almacenar(curso);
        assertEquals("Curso registrado exitosamente", resultado);

    }

    @Test
    void almacenarCursoExistente(){
        Curso curso = new Curso();
        curso.setSigla("CURSOFULLSTACK001");

        when(cursoRepository.findById(curso.getSigla())).thenReturn(Optional.of(curso));

        String resultado = cursoService.almacenar(curso);
        assertEquals("El curso con sigla "+ curso.getSigla() +" ya existe.", resultado);

    }

    @Test
    void eliminarCursoExistente() {
        Curso cursoEliminar = new Curso();
        cursoEliminar.setSigla("CursoObsoleto001");


        when(cursoRepository.existsById(cursoEliminar.getSigla())).thenReturn(true);

        String resultado = cursoService.eliminar(cursoEliminar.getSigla());
        assertEquals("Curso eliminado exitosamente", resultado);
    }

    @Test
    void actualizarCurso() {
        String siglaCursoAntiguo = "FSTK001";
        Curso cursoNuevo = new Curso();
        cursoNuevo.setSigla("FSTK002");
        cursoNuevo.setNombre("Fullstack Nueva Malla");
        cursoNuevo.setDescripcion("Nuevo Ramo Fullstack");

        when(cursoRepository.existsById(siglaCursoAntiguo)).thenReturn(true);

        String resultado = cursoService.actualizar(siglaCursoAntiguo, cursoNuevo);
        assertEquals("Curso actualizado exitosamente", resultado);
    }

    @Test
    void listarCursos() {
        Curso c01 = new Curso();
        c01.setSigla("C01");
        c01.setNombre("NombreCurso01");

        Usuario u01 = new Usuario();
        u01.setRut("11111111-1");
        u01.setNombre("Juan");
        u01.setApellido("Pérez");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u01);
        c01.setUsuarios(usuarios);

        Curso c02 = new Curso();
        c02.setSigla("C02");
        c02.setNombre("NombreCurso02");

        List<Usuario> usuariosVacios = new ArrayList<>();

        c02.setUsuarios(usuariosVacios);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(c01);
        cursos.add(c02);

        when(cursoRepository.findAll()).thenReturn(cursos);

        List<CursoDTO> resultado = cursoService.listarCursos();

        assertEquals(2, resultado.size());
        assertEquals("C01", resultado.get(0).getSigla());
        assertEquals("Juan", resultado.get(0).getUsuarios().get(0).getNombre());
    }




}

