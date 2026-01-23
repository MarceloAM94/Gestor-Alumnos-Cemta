package com.academia.gestion_alumnos.repository;

import com.academia.gestion_alumnos.domain.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Optional<Alumno> findByDni(String dni);

    boolean existsByDni(String dni);
}
