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
@Table(name = "compra_evento")
public class CompraEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Eventos evento;

    @ManyToOne
    @JoinColumn(name = "tipo_entrada_id", nullable = false)
    private TipoEntrada tipoEntrada;

    private String codigoPromocional;

    private double precioFinal;

    @PrePersist
    @PreUpdate
    public void calcularPrecioFinal() {
        double porcentajeAdicional = tipoEntrada.getPorcentajeAdicional();
        double valorBase = evento.getValorBase();
        this.precioFinal = valorBase + (valorBase * porcentajeAdicional / 100);
    }
}
