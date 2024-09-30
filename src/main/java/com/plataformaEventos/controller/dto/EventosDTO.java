package com.plataformaEventos.controller.dto;

import com.plataformaEventos.entiti.Inscripciones;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EventosDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;
    private int cupoDisponible;
    private boolean tipo;
    private double valorBase;
    private String categoria;
    private int capacidadEvento;
    private String fechaApertura;
    private String fechaCierre;

    private boolean opcionCompra;
    //private List<Inscripciones> inscripciones;
}
