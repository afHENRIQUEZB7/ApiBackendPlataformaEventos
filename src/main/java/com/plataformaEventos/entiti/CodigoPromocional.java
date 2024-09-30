package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "codigos_promocionales")
public class CodigoPromocional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private double descuento;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Eventos evento;
}
