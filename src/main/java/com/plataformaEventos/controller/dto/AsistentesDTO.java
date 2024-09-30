package com.plataformaEventos.controller.dto;

import com.plataformaEventos.entiti.Eventos;
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
public class AsistentesDTO {
    private long id;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String email;
    private String celular;

    //private List<Inscripciones> inscripciones;

}
