package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.CodigoPromocionalDTO;
import com.plataformaEventos.controller.dto.EventosDTO;
import com.plataformaEventos.entiti.CodigoPromocional;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.service.ICodigoPromocionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/codigoPromocional")
public class CodigoPromocionalController {

    @Autowired
    private ICodigoPromocionalService iCodigoPromocionalService;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CodigoPromocionalDTO codigoPromocionalDTO) {
        if (codigoPromocionalDTO.getCodigo().isBlank()) {
            return new ResponseEntity<>("Codigo promocional nulo", HttpStatus.NOT_FOUND);
        }

        CodigoPromocionalDTO codigoPromocionalDTO1 = iCodigoPromocionalService.save(CodigoPromocional.builder()
                .codigo(codigoPromocionalDTO.getCodigo())
                .activo(codigoPromocionalDTO.isActivo())
                .fechaInicio(codigoPromocionalDTO.getFechaInicio())
                .fechaFin(codigoPromocionalDTO.getFechaFin())
                .descuento(codigoPromocionalDTO.getDescuento())
                .evento(Eventos.builder()
                        .id(codigoPromocionalDTO.getEvento().getId())
                        .build())
                .build());

        return new ResponseEntity<>("Codigo Prmocional creado con exito id: " + codigoPromocionalDTO1.getId(), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCodigoPromocional(@RequestBody CodigoPromocionalDTO codigoPromocionalDTO, @PathVariable Long id) {
        Optional<CodigoPromocional> codigoPromocional = iCodigoPromocionalService.findById(id);
        if (codigoPromocional.isPresent()) {
            CodigoPromocional codigoPromocionalUpdate = codigoPromocional.get();
            codigoPromocionalUpdate.setCodigo(codigoPromocionalDTO.getCodigo());
            codigoPromocionalUpdate.setActivo(codigoPromocionalDTO.isActivo());
            codigoPromocionalUpdate.setFechaInicio(codigoPromocionalDTO.getFechaInicio());
            codigoPromocionalUpdate.setFechaFin(codigoPromocionalDTO.getFechaFin());
            codigoPromocionalUpdate.setDescuento(codigoPromocionalDTO.getDescuento());
            codigoPromocionalUpdate.setEvento(Eventos.builder()
                    .titulo(codigoPromocionalDTO.getEvento().getTitulo())
                    .descripcion(codigoPromocionalDTO.getEvento().getDescripcion())
                    .fecha(codigoPromocionalDTO.getEvento().getFecha())
                    .hora(codigoPromocionalDTO.getEvento().getHora())
                    .lugar(codigoPromocionalDTO.getEvento().getLugar())
                    .cupoDisponible(codigoPromocionalDTO.getEvento().getCupoDisponible())
                    .tipo(codigoPromocionalDTO.getEvento().isTipo())
                    .valorBase(codigoPromocionalDTO.getEvento().getValorBase())
                    .categoria(codigoPromocionalDTO.getEvento().getCategoria())
                    .capacidadEvento(codigoPromocionalDTO.getEvento().getCapacidadEvento())
                    .fechaApertura(codigoPromocionalDTO.getEvento().getFechaApertura())
                    .fechaCierre(codigoPromocionalDTO.getEvento().getFechaCierre())
                    .opcionCompra(codigoPromocionalDTO.getEvento().isOpcionCompra())
                    .build());

            return new ResponseEntity<>("Codigo Promocional modificado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Codigo Promocional no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<CodigoPromocional> codigoPromocional = iCodigoPromocionalService.findById(id);
        if (codigoPromocional.isPresent()) {
            iCodigoPromocionalService.deleteById(id);
            return new ResponseEntity<>("Codigo Promocional eliminado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Codigo Promocional no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<CodigoPromocionalDTO> codigoPromocionalDTOS = iCodigoPromocionalService.findAll()
                .stream()
                .map(codigoPromocional -> CodigoPromocionalDTO.builder()
                        .id(codigoPromocional.getId())
                        .codigo(codigoPromocional.getCodigo())
                        .activo(codigoPromocional.isActivo())
                        .fechaInicio(codigoPromocional.getFechaInicio())
                        .fechaFin(codigoPromocional.getFechaFin())
                        .descuento(codigoPromocional.getDescuento())
                        .evento(EventosDTO.builder()
                                .id(codigoPromocional.getEvento().getId())
                                .titulo(codigoPromocional.getEvento().getTitulo())
                                .descripcion(codigoPromocional.getEvento().getDescripcion())
                                .fecha(codigoPromocional.getEvento().getFecha())
                                .hora(codigoPromocional.getEvento().getHora())
                                .lugar(codigoPromocional.getEvento().getLugar())
                                .cupoDisponible(codigoPromocional.getEvento().getCupoDisponible())
                                .tipo(codigoPromocional.getEvento().isTipo())
                                .valorBase(codigoPromocional.getEvento().getValorBase())
                                .categoria(codigoPromocional.getEvento().getCategoria())
                                .capacidadEvento(codigoPromocional.getEvento().getCapacidadEvento())
                                .fechaApertura(codigoPromocional.getEvento().getFechaApertura())
                                .fechaCierre(codigoPromocional.getEvento().getFechaCierre())
                                .opcionCompra(codigoPromocional.getEvento().isOpcionCompra())
                                .build())
                        .build())
                .toList();

        return new ResponseEntity<>(codigoPromocionalDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<CodigoPromocional> codigoPromocional = iCodigoPromocionalService.findById(id);
        if (codigoPromocional.isPresent()) {
            CodigoPromocional codigoPromocionalById = codigoPromocional.get();
            return new ResponseEntity<>(CodigoPromocionalDTO.builder()
                    .id(codigoPromocionalById.getId())
                    .codigo(codigoPromocionalById.getCodigo())
                    .activo(codigoPromocionalById.isActivo())
                    .fechaInicio(codigoPromocionalById.getFechaInicio())
                    .fechaFin(codigoPromocionalById.getFechaFin())
                    .descuento(codigoPromocionalById.getDescuento())
                    .evento(EventosDTO.builder()
                            .id(codigoPromocionalById.getEvento().getId())
                            .titulo(codigoPromocionalById.getEvento().getTitulo())
                            .descripcion(codigoPromocionalById.getEvento().getDescripcion())
                            .fecha(codigoPromocionalById.getEvento().getFecha())
                            .hora(codigoPromocionalById.getEvento().getHora())
                            .lugar(codigoPromocionalById.getEvento().getLugar())
                            .cupoDisponible(codigoPromocionalById.getEvento().getCupoDisponible())
                            .tipo(codigoPromocionalById.getEvento().isTipo())
                            .valorBase(codigoPromocionalById.getEvento().getValorBase())
                            .categoria(codigoPromocionalById.getEvento().getCategoria())
                            .capacidadEvento(codigoPromocionalById.getEvento().getCapacidadEvento())
                            .fechaApertura(codigoPromocionalById.getEvento().getFechaApertura())
                            .fechaCierre(codigoPromocionalById.getEvento().getFechaCierre())
                            .opcionCompra(codigoPromocionalById.getEvento().isOpcionCompra())
                            .build())
                    .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Codigo Promocional no encontrado", HttpStatus.NOT_FOUND);
    }

}
