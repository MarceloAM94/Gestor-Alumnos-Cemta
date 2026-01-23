package com.academia.gestion_alumnos.service.impl;

import com.academia.gestion_alumnos.domain.entity.Alumno;
import com.academia.gestion_alumnos.repository.AlumnoRepository;
import com.academia.gestion_alumnos.repository.TutorRepository;
import com.academia.gestion_alumnos.service.AlumnoService;
import com.academia.gestion_alumnos.service.TutorService;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final TutorRepository tutorRepository;

    public AlumnoServiceImpl(
            AlumnoRepository alumnoRepository,
            TutorRepository tutorRepository
    ) {
        this.alumnoRepository = alumnoRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Alumno crearAlumno(Alumno alumno) {

        //Regla 1: DNI unico
        if (alumnoRepository.existsByDni(alumno.getDni())){
            throw new IllegalArgumentException("El DNI ya existe");
        }

        //Regla 2: Tutor debe existir
        Long tutorId = alumno.getTutor().getId();
        if (!tutorRepository.existsById(tutorId)){
            throw new IllegalArgumentException("El tutor no existe");
        }

        return alumnoRepository.save(alumno);

    }
}
