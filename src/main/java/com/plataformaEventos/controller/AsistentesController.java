package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.AsistentesDTO;
import com.plataformaEventos.controller.dto.AsistentesDTOHerencia;
import com.plataformaEventos.entiti.Asistentes;
import com.plataformaEventos.service.IAsistentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asistentes")
public class AsistentesController {

    @Autowired
    private  IAsistentesService asistentesService;


    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AsistentesDTOHerencia asistentesDTO) {
        if (asistentesDTO.getNombres().isBlank()) {
            return ResponseEntity.badRequest().body("Nombes nulo");
        }
        asistentesService.save(Asistentes.builder()
                        .nombres(asistentesDTO.getNombres())
                        .apellidos(asistentesDTO.getApellidos())
                        .fechaNacimiento(asistentesDTO.getFechaNacimiento())
                        .email(asistentesDTO.getEmail())
                        .celular(asistentesDTO.getCelular())
                        .inscripciones(asistentesDTO.getInscripciones())
                        .build());

        return new ResponseEntity<>("Asistente registrado con exito: " + asistentesDTO, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAsistente(@RequestBody AsistentesDTO asistentesDTO, @PathVariable long id) {
        Optional<Asistentes> asistentes = asistentesService.findById(id);

        if (asistentes.isPresent()) {
            Asistentes asistenteUpdate = asistentes.get();
            asistenteUpdate.setId(id);
            asistenteUpdate.setNombres(asistentesDTO.getNombres());
            asistenteUpdate.setApellidos(asistentesDTO.getApellidos());
            asistenteUpdate.setFechaNacimiento(asistentesDTO.getFechaNacimiento());
            asistenteUpdate.setEmail(asistentesDTO.getEmail());
            asistenteUpdate.setCelular(asistentesDTO.getCelular());

            asistentesService.save(asistenteUpdate);

            return new ResponseEntity<>("Asistente modificado con exito: " + asistenteUpdate,HttpStatus.OK);
        }

        return new ResponseEntity<>("Asistente no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Asistentes> asistentes = asistentesService.findById(id);
        if (asistentes.isPresent()) {
            asistentesService.deleteById(id);
            return new ResponseEntity<>("Asistente eliminado con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Asistente no encontrado", HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<AsistentesDTO> asistentes = asistentesService.findAll()
                .stream()
                .map(asistete -> AsistentesDTO.builder()
                        .id(asistete.getId())
                        .nombres(asistete.getNombres())
                        .apellidos(asistete.getApellidos())
                        .fechaNacimiento(asistete.getFechaNacimiento())
                        .email(asistete.getEmail())
                        .celular(asistete.getCelular())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(asistentes, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/allNombre")
    public ResponseEntity<?> filtrarPorNombre(@RequestParam String nombre) {
        List<AsistentesDTO> asistentesDTOS = asistentesService.filtrarPorNombre(nombre)
                .stream()
                .map(asistentes ->AsistentesDTO.builder()
                        .nombres(asistentes.getNombres())
                        .apellidos(asistentes.getApellidos())
                        .fechaNacimiento(asistentes.getFechaNacimiento())
                        .email(asistentes.getEmail())
                        .celular(asistentes.getCelular())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(asistentesDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/allApellidos")
    public ResponseEntity<?> filtrarPorApellido(@RequestParam String apellido) {
        List<AsistentesDTO> asistentesDTOS = asistentesService.filtrarPorApellido(apellido)
                .stream()
                .map(asistentes -> AsistentesDTO.builder()
                        .nombres(asistentes.getNombres())
                        .apellidos(asistentes.getApellidos())
                        .fechaNacimiento(asistentes.getFechaNacimiento())
                        .email(asistentes.getEmail())
                        .celular(asistentes.getCelular())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(asistentesDTOS, HttpStatus.OK);
    }
}
