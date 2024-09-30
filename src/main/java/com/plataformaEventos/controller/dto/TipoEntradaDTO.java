package com.plataformaEventos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoEntradaDTO {

    private Long id;

    private String nombre;

    private double porcentajeAdicional;
}
