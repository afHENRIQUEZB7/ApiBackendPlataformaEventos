package com.plataformaEventos.controller.dto;

import com.plataformaEventos.entiti.Eventos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodigoPromocionalDTO {

    private Long id;
    private String codigo;
    private boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private double descuento;

    private EventosDTO evento;
}
