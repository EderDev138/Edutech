package com.edutech.apiedutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.apiedutech.dto.AdministradorDTO;
import com.edutech.apiedutech.dto.ProfesorDTO;
import com.edutech.apiedutech.model.Administrador;
import com.edutech.apiedutech.model.Profesor;
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



}
