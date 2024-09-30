package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.EventosDTO;
import com.plataformaEventos.controller.dto.EventosDTOHerencia;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.service.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
public class EventosController {

    @Autowired
    private IEventosService eventosService;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EventosDTOHerencia eventosDto) {
        if (eventosDto.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("Titulo nulo");
        }

        Eventos eventos = eventosService.save(Eventos.builder()
                        .titulo(eventosDto.getTitulo())
                        .descripcion(eventosDto.getDescripcion())
                        .fecha(eventosDto.getFecha())
                        .hora(eventosDto.getHora())
                        .lugar(eventosDto.getLugar())
                        .cupoDisponible(eventosDto.getCupoDisponible())
                        .tipo(eventosDto.isTipo())
                        .valorBase(eventosDto.getValorBase())
                        .categoria(eventosDto.getCategoria())
                        .capacidadEvento(eventosDto.getCapacidadEvento())
                        .fechaApertura(eventosDto.getFechaApertura())
                        .fechaCierre(eventosDto.getFechaCierre())
                        .inscripciones(eventosDto.getInscripciones())
                        .build()
        );

        return new ResponseEntity<>("Evento creado con exito id: " + eventos.getId(), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEvento(@PathVariable Long id, @RequestBody EventosDTOHerencia eventosDto) {
        Optional<Eventos> eventos = eventosService.findById(id);

        if (eventos.isPresent()) {
            Eventos eventoUpdate = eventos.get();
            eventoUpdate.setId(id);
            eventoUpdate.setTitulo(eventosDto.getTitulo());
            eventoUpdate.setDescripcion(eventosDto.getDescripcion());
            eventoUpdate.setFecha(eventosDto.getFecha());
            eventoUpdate.setHora(eventosDto.getHora());
            eventoUpdate.setLugar(eventosDto.getLugar());
            eventoUpdate.setCupoDisponible(eventosDto.getCupoDisponible());
            eventoUpdate.setTipo(eventosDto.isTipo());
            eventoUpdate.setValorBase(eventosDto.getValorBase());
            eventoUpdate.setCategoria(eventosDto.getCategoria());
            eventoUpdate.setCapacidadEvento(eventosDto.getCapacidadEvento());
            eventoUpdate.setFechaApertura(eventosDto.getFechaApertura());
            eventoUpdate.setFechaCierre(eventosDto.getFechaCierre());
            eventoUpdate.setInscripciones(eventosDto.getInscripciones());
            eventosService.save(eventoUpdate);
            return new ResponseEntity<>("Evento modificado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Eventos> eventos = eventosService.findById(id);
        if (eventos.isPresent()) {
            eventosService.deleteById(id);
            return new ResponseEntity<>("Evento eliminado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<EventosDTO> eventosDTOList = eventosService.findAll()
                .stream()
                .map(eventos -> EventosDTO.builder()
                        .id(eventos.getId())
                        .titulo(eventos.getTitulo())
                        .descripcion(eventos.getDescripcion())
                        .fecha(eventos.getFecha())
                        .hora(eventos.getHora())
                        .lugar(eventos.getLugar())
                        .cupoDisponible(eventos.getCupoDisponible())
                        .tipo(eventos.isTipo())
                        .valorBase(eventos.getValorBase())
                        .categoria(eventos.getCategoria())
                        .capacidadEvento(eventos.getCapacidadEvento())
                        .fechaApertura(eventos.getFechaApertura())
                        .fechaCierre(eventos.getFechaCierre())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(eventosDTOList, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Eventos> evento = eventosService.findById(id);
        if (evento.isPresent()) {
            Eventos eventos = evento.get();
            return new ResponseEntity<>(EventosDTO.builder()
                    .id(eventos.getId())
                    .titulo(eventos.getTitulo())
                    .descripcion(eventos.getDescripcion())
                    .fecha(eventos.getFecha())
                    .hora(eventos.getHora())
                    .lugar(eventos.getLugar())
                    .cupoDisponible(eventos.getCupoDisponible())
                    .tipo(eventos.isTipo())
                    .valorBase(eventos.getValorBase())
                    .categoria(eventos.getCategoria())
                    .capacidadEvento(eventos.getCapacidadEvento())
                    .fechaApertura(eventos.getFechaApertura())
                    .fechaCierre(eventos.getFechaCierre())
                    .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND);
    }
}
