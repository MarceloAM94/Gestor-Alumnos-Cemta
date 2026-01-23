package com.academia.gestion_alumnos.service.impl;

import com.academia.gestion_alumnos.domain.entity.Tutor;
import com.academia.gestion_alumnos.repository.TutorRepository;
import com.academia.gestion_alumnos.service.TutorService;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor crearTutor(Tutor tutor) {

        if (tutorRepository.existsByCodigoTutor(tutor.getCodigoTutor())) {
            throw new IllegalArgumentException("El código de tutor ya existe");
        }

        return tutorRepository.save(tutor);
    }
}
