package com.plataformaEventos.controller.dto;

import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.entiti.TipoEntrada;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraEventoDTO {

    private Long id;

    private EventosDTO evento;

    private TipoEntradaDTO tipoEntrada;

    private String codigoPromocional;

    private double precioFinal;
}
