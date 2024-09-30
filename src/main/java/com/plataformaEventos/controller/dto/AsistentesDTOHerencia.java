package com.plataformaEventos.controller.dto;

import com.plataformaEventos.entiti.Inscripciones;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AsistentesDTOHerencia extends AsistentesDTO {
    private List<Inscripciones> inscripciones;
}
