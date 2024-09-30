package com.plataformaEventos.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscripcionesDTO {

    private Long id;

    private EventosDTO evento;

    private AsistentesDTO asistente;

    private boolean cancelado = false;

    private LocalDateTime fechaInscripcion;
}
