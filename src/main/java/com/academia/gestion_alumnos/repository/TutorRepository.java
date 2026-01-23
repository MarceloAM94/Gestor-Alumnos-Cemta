package com.academia.gestion_alumnos.repository;

import com.academia.gestion_alumnos.domain.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByCodigoTutor(String codigoTutor);

    boolean existsByCodigoTutor(String codigoTutor);

}
