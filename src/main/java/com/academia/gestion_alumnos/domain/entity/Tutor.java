package com.academia.gestion_alumnos.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tutores")

@Getter @Setter
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El codigo de tutor es obligatorio")
    @Column(nullable = false, unique = true)
    private String codigoTutor;

    @NotBlank(message = "El nombre del tutor es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tutor")
    private List<Alumno> alumnos;

}