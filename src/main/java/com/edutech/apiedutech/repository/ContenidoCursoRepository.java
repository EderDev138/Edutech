package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.ContenidoCurso;

public interface ContenidoCursoRepository extends JpaRepository<ContenidoCurso, Long> {
    
    public ContenidoCurso findById(long id);

}
