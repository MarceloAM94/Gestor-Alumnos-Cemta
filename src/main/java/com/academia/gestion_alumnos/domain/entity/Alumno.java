package com.academia.gestion_alumnos.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "alumnos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "dni")
        }
)

@Getter @Setter
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(
            regexp = "\\d{8}",
            message = "El DNI debe tener exactamente 8 digitos"
    )
    @Column(nullable = false, length = 8)
    private String dni;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Column(nullable = false)
    private String primerNombre;

    private String segundoNombre;

    @NotBlank(message = "El primer apellido es obligatorio")
    @Column(nullable = false)
    private String primerApellido;

    private String segundoApellido;

    @NotBlank(message = "El alumno debe tener un tutor asignado")
    @ManyToOne(optional = false)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

}