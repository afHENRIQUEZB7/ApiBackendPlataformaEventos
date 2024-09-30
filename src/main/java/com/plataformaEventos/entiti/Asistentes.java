package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asistentes")
public class Asistentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombres;
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    private String email;
    private String celular;

    @OneToMany(mappedBy = "asistente")
    private List<Inscripciones> inscripciones;
}
