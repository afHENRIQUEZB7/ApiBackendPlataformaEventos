package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.AsistentesDTO;
import com.plataformaEventos.controller.dto.EventosDTO;
import com.plataformaEventos.controller.dto.InscripcionesDTO;
import com.plataformaEventos.entiti.Asistentes;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.entiti.Inscripciones;
import com.plataformaEventos.service.IInscripcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incripciones")
public class InscripcionesController {

    @Autowired
    private IInscripcionesService inscripcionesService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<InscripcionesDTO> inscripcionesDTOS = inscripcionesService.findAll()
                .stream()
                .map(inscripcion -> {
                    Eventos evento = inscripcion.getEvento();
                    EventosDTO eventosDTO =  EventosDTO.builder()
                            .id(evento.getId())
                            .titulo(evento.getTitulo())
                            .descripcion(evento.getDescripcion())
                            .fecha(evento.getFecha())
                            .hora(evento.getHora())
                            .lugar(evento.getLugar())
                            .cupoDisponible(evento.getCupoDisponible())
                            .tipo(evento.isTipo())
                            .valorBase(evento.getValorBase())
                            .categoria(evento.getCategoria())
                            .capacidadEvento(evento.getCapacidadEvento())
                            .fechaApertura(evento.getFechaApertura())
                            .fechaCierre(evento.getFechaCierre())
                            .build();

                    Asistentes asistente = inscripcion.getAsistente();
                    AsistentesDTO asistentesDTO = AsistentesDTO.builder()
                            .id(asistente.getId())
                            .nombres(asistente.getNombres())
                            .apellidos(asistente.getApellidos())
                            .fechaNacimiento(asistente.getFechaNacimiento())
                            .email(asistente.getEmail())
                            .celular(asistente.getCelular())
                            .build();

                    return InscripcionesDTO.builder()
                        .id(inscripcion.getId())
                        .evento(eventosDTO)
                        .asistente(asistentesDTO)
                        .cancelado(inscripcion.isCancelado())
                        .fechaInscripcion(inscripcion.getFechaInscripcion())
                        .build();
                })
                .toList();

        return new ResponseEntity<>(inscripcionesDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Inscripciones> incripcion = inscripcionesService.findById(id);

        if (incripcion.isPresent()) {
            Inscripciones inscripcion = incripcion.get();

            Eventos evento = inscripcion.getEvento();
            EventosDTO eventosDTO =  EventosDTO.builder()
                    .id(evento.getId())
                    .titulo(evento.getTitulo())
                    .descripcion(evento.getDescripcion())
                    .fecha(evento.getFecha())
                    .hora(evento.getHora())
                    .lugar(evento.getLugar())
                    .cupoDisponible(evento.getCupoDisponible())
                    .tipo(evento.isTipo())
                    .valorBase(evento.getValorBase())
                    .categoria(evento.getCategoria())
                    .capacidadEvento(evento.getCapacidadEvento())
                    .fechaApertura(evento.getFechaApertura())
                    .fechaCierre(evento.getFechaCierre())
                    .build();

            Asistentes asistente = inscripcion.getAsistente();
            AsistentesDTO asistentesDTO = AsistentesDTO.builder()
                    .id(asistente.getId())
                    .nombres(asistente.getNombres())
                    .apellidos(asistente.getApellidos())
                    .fechaNacimiento(asistente.getFechaNacimiento())
                    .email(asistente.getEmail())
                    .celular(asistente.getCelular())
                    .build();

            return new ResponseEntity<>(InscripcionesDTO.builder()
                    .id(inscripcion.getId())
                    .evento(eventosDTO)
                    .asistente(asistentesDTO)
                    .cancelado(inscripcion.isCancelado())
                    .fechaInscripcion(inscripcion.getFechaInscripcion())
                    .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Inscripción no encontrada",HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InscripcionesDTO inscripcionesDTO) {

        EventosDTO eventosDTO = inscripcionesDTO.getEvento();
        Eventos eventos =  Eventos.builder()
                .id(eventosDTO.getId())
                .titulo(eventosDTO.getTitulo())
                .descripcion(eventosDTO.getDescripcion())
                .fecha(eventosDTO.getFecha())
                .hora(eventosDTO.getHora())
                .lugar(eventosDTO.getLugar())
                .cupoDisponible(eventosDTO.getCupoDisponible())
                .tipo(eventosDTO.isTipo())
                .valorBase(eventosDTO.getValorBase())
                .categoria(eventosDTO.getCategoria())
                .capacidadEvento(eventosDTO.getCapacidadEvento())
                .fechaApertura(eventosDTO.getFechaApertura())
                .fechaCierre(eventosDTO.getFechaCierre())
                .build();

        AsistentesDTO asistentesDTO = inscripcionesDTO.getAsistente();
        Asistentes  asistentes = Asistentes.builder()
                .id(asistentesDTO.getId())
                .nombres(asistentesDTO.getNombres())
                .apellidos(asistentesDTO.getApellidos())
                .fechaNacimiento(asistentesDTO.getFechaNacimiento())
                .email(asistentesDTO.getEmail())
                .celular(asistentesDTO.getCelular())
                .build();
        
        inscripcionesService.save(Inscripciones.builder()
                .evento(eventos)
                .asistente(asistentes)
                .cancelado(inscripcionesDTO.isCancelado())
                .fechaInscripcion(inscripcionesDTO.getFechaInscripcion())
                .build());

        return new ResponseEntity<>("Incripcion guardada con exito",HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Inscripciones> inscripciones = inscripcionesService.findById(id);
        if (inscripciones.isPresent()) {
            inscripcionesService.deleteById(id);
            return new ResponseEntity<>("Inscripcion eliminada con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Inscripcion no encontrada", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping("/asistente/{id}")
    public ResponseEntity<?> filtrarPorIdAsistente(@PathVariable Long id) {
        List<InscripcionesDTO> inscripcionesDTOS = inscripcionesService.filtrarPorIdAsistente(id)
                .stream()
                .map(inscripcion -> {
                    Eventos evento = inscripcion.getEvento();
                    EventosDTO eventosDTO =  EventosDTO.builder()
                            .id(evento.getId())
                            .titulo(evento.getTitulo())
                            .descripcion(evento.getDescripcion())
                            .fecha(evento.getFecha())
                            .hora(evento.getHora())
                            .lugar(evento.getLugar())
                            .cupoDisponible(evento.getCupoDisponible())
                            .tipo(evento.isTipo())
                            .valorBase(evento.getValorBase())
                            .categoria(evento.getCategoria())
                            .capacidadEvento(evento.getCapacidadEvento())
                            .fechaApertura(evento.getFechaApertura())
                            .fechaCierre(evento.getFechaCierre())
                            .build();

                    Asistentes asistente = inscripcion.getAsistente();
                    AsistentesDTO asistentesDTO = AsistentesDTO.builder()
                            .id(asistente.getId())
                            .nombres(asistente.getNombres())
                            .apellidos(asistente.getApellidos())
                            .fechaNacimiento(asistente.getFechaNacimiento())
                            .email(asistente.getEmail())
                            .celular(asistente.getCelular())
                            .build();

                    return InscripcionesDTO.builder()
                            .id(inscripcion.getId())
                            .evento(eventosDTO)
                            .asistente(asistentesDTO)
                            .cancelado(inscripcion.isCancelado())
                            .fechaInscripcion(inscripcion.getFechaInscripcion())
                            .build();
                })
                .toList();
        return new ResponseEntity<>(inscripcionesDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/evento/{id}")
    public ResponseEntity<?> findByEventoId(@PathVariable Long id) {
        List<InscripcionesDTO> inscripcionesDTOS = inscripcionesService.filtrarPorIdEvento(id)
                .stream()
                .map(inscripcion -> {
                    Eventos evento = inscripcion.getEvento();
                    EventosDTO eventosDTO =  EventosDTO.builder()
                            .id(evento.getId())
                            .titulo(evento.getTitulo())
                            .descripcion(evento.getDescripcion())
                            .fecha(evento.getFecha())
                            .hora(evento.getHora())
                            .lugar(evento.getLugar())
                            .cupoDisponible(evento.getCupoDisponible())
                            .tipo(evento.isTipo())
                            .valorBase(evento.getValorBase())
                            .categoria(evento.getCategoria())
                            .capacidadEvento(evento.getCapacidadEvento())
                            .fechaApertura(evento.getFechaApertura())
                            .fechaCierre(evento.getFechaCierre())
                            .build();

                    Asistentes asistente = inscripcion.getAsistente();
                    AsistentesDTO asistentesDTO = AsistentesDTO.builder()
                            .id(asistente.getId())
                            .nombres(asistente.getNombres())
                            .apellidos(asistente.getApellidos())
                            .fechaNacimiento(asistente.getFechaNacimiento())
                            .email(asistente.getEmail())
                            .celular(asistente.getCelular())
                            .build();

                    return InscripcionesDTO.builder()
                            .id(inscripcion.getId())
                            .evento(eventosDTO)
                            .asistente(asistentesDTO)
                            .cancelado(inscripcion.isCancelado())
                            .fechaInscripcion(inscripcion.getFechaInscripcion())
                            .build();
                })
                .toList();
        return new ResponseEntity<>(inscripcionesDTOS, HttpStatus.OK);
    }
}
