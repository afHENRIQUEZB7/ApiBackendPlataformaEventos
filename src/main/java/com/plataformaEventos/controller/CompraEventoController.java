package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.CompraEventoDTO;
import com.plataformaEventos.controller.dto.EventosDTO;
import com.plataformaEventos.controller.dto.TipoEntradaDTO;
import com.plataformaEventos.entiti.CompraEvento;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.entiti.TipoEntrada;
import com.plataformaEventos.service.ICompraEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compraEvento")
public class CompraEventoController {

    @Autowired
    private ICompraEventoService compraEventoService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<CompraEventoDTO> compraEventoDTOS = compraEventoService.findAll()
                .stream()
                .map(compraEvento -> CompraEventoDTO.builder()
                        .id(compraEvento.getId())
                        .evento(EventosDTO.builder()
                                        .id(compraEvento.getEvento().getId())
                                        .titulo(compraEvento.getEvento().getTitulo())
                                        .descripcion(compraEvento.getEvento().getDescripcion())
                                        .fecha(compraEvento.getEvento().getFecha())
                                        .hora(compraEvento.getEvento().getHora())
                                        .lugar(compraEvento.getEvento().getHora())
                                        .cupoDisponible(compraEvento.getEvento().getCupoDisponible())
                                        .tipo(compraEvento.getEvento().isTipo())
                                        .valorBase(compraEvento.getEvento().getValorBase())
                                        .categoria(compraEvento.getEvento().getCategoria())
                                        .capacidadEvento(compraEvento.getEvento().getCapacidadEvento())
                                        .fechaApertura(compraEvento.getEvento().getFechaApertura())
                                        .fechaCierre(compraEvento.getEvento().getFechaCierre())
                                        .opcionCompra(compraEvento.getEvento().isOpcionCompra())
                                        .build()
                                )
                        .tipoEntrada(TipoEntradaDTO.builder()
                                        .id(compraEvento.getTipoEntrada().getId())
                                        .nombre(compraEvento.getTipoEntrada().getNombre())
                                        .porcentajeAdicional(compraEvento.getTipoEntrada().getPorcentajeAdicional())
                                        .build()
                                    )
                        .codigoPromocional(compraEvento.getCodigoPromocional())
                        .precioFinal(compraEvento.getPrecioFinal())
                        .build())
                .toList();

        return new ResponseEntity<>(compraEventoDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/save")
    public ResponseEntity<?> save(@RequestBody CompraEventoDTO compraEventoDTO){
        if (compraEventoDTO.getEvento() == null && compraEventoDTO.getTipoEntrada() == null) {
            return ResponseEntity.badRequest().body("Evento y Tipo de entrada nulos");
        }

        CompraEvento compraEvento = compraEventoService.save(CompraEvento.builder()
                .id(compraEventoDTO.getId())
                .evento(Eventos.builder()
                        .id(compraEventoDTO.getEvento().getId())
                        .titulo(compraEventoDTO.getEvento().getTitulo())
                        .descripcion(compraEventoDTO.getEvento().getDescripcion())
                        .fecha(compraEventoDTO.getEvento().getFecha())
                        .hora(compraEventoDTO.getEvento().getHora())
                        .lugar(compraEventoDTO.getEvento().getHora())
                        .cupoDisponible(compraEventoDTO.getEvento().getCupoDisponible())
                        .tipo(compraEventoDTO.getEvento().isTipo())
                        .valorBase(compraEventoDTO.getEvento().getValorBase())
                        .categoria(compraEventoDTO.getEvento().getCategoria())
                        .capacidadEvento(compraEventoDTO.getEvento().getCapacidadEvento())
                        .fechaApertura(compraEventoDTO.getEvento().getFechaApertura())
                        .fechaCierre(compraEventoDTO.getEvento().getFechaCierre())
                        .opcionCompra(compraEventoDTO.getEvento().isOpcionCompra())
                        .build()
                )
                .tipoEntrada(TipoEntrada.builder()
                        .id(compraEventoDTO.getTipoEntrada().getId())
                        .nombre(compraEventoDTO.getTipoEntrada().getNombre())
                        .porcentajeAdicional(compraEventoDTO.getTipoEntrada().getPorcentajeAdicional())
                        .build()
                )
                .codigoPromocional(compraEventoDTO.getCodigoPromocional())
                .precioFinal(compraEventoDTO.getPrecioFinal())
                .build());

        return new ResponseEntity<>("Evento creado con exito id: " + compraEvento.getId(), HttpStatus.OK);
    }
}
