package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscripciones")
public class Inscripciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Eventos evento;

    @ManyToOne
    @JoinColumn(name = "asistente_id")
    private Asistentes asistente;

    private boolean cancelado = false;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime fechaInscripcion;
}
