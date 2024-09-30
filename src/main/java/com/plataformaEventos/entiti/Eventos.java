package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;
    @Column(name = "cupo_disponible")
    private int cupoDisponible;
    private boolean tipo;
    @Column(name = "valor_base")
    private double valorBase;
    private String categoria;
    @Column(name = "capacidad_evento")
    private int capacidadEvento;
    @Column(name = "fecha_apertura")
    private String fechaApertura;
    @Column(name = "fecha_cierre")
    private String fechaCierre;

    @OneToMany(mappedBy = "evento")
    private List<Inscripciones> inscripciones;

}
