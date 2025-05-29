package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {

}
