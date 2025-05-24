package com.edutech.apiedutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.apiedutech.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, puedes buscar profesores por su nombre o apellido
    // List<Profesor> findByNombre(String nombre);
    // List<Profesor> findByApellido(String apellido);

}
