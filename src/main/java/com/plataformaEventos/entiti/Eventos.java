package com.plataformaEventos.entiti;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 2147483647)
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;
    @Column(name = "cupo_disponible")
    private int cupoDisponible;
    private boolean tipo;
    @Column(name = "valor_base")
    private double valorBase;
    private String categoria;
    @Column(name = "capacidad_evento")
    private int capacidadEvento;
    @Column(name = "fecha_apertura")
    private String fechaApertura;
    @Column(name = "fecha_cierre")
    private String fechaCierre;

    //  Validación para que muestre que este con la opción de compra
    @Column(name = "opcion_compra")
    private boolean opcionCompra;

    @OneToMany(mappedBy = "evento")
    private List<Inscripciones> inscripciones;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<CodigoPromocional> codigosPromocionales;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "evento_id")
//    private List<TipoEntrada> tiposEntrada;

}
