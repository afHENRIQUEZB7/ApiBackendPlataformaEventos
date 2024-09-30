package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_entrada")
public class TipoEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "porcentaje_adicional")
    private double porcentajeAdicional;
}
