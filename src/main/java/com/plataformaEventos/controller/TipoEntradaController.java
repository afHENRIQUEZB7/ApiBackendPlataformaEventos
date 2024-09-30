package com.plataformaEventos.controller;

import com.plataformaEventos.controller.dto.TipoEntradaDTO;
import com.plataformaEventos.entiti.TipoEntrada;
import com.plataformaEventos.service.ITipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoEntrada")
public class TipoEntradaController {

    @Autowired
    private ITipoEntradaService tipoEntradaService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<TipoEntradaDTO> tipoEntradasDtos = tipoEntradaService.findAll()
                .stream()
                .map(tipoEntrada -> TipoEntradaDTO.builder()
                        .id(tipoEntrada.getId())
                        .nombre(tipoEntrada.getNombre())
                        .porcentajeAdicional(tipoEntrada.getPorcentajeAdicional())
                        .build())
                .toList();

        return new ResponseEntity<>(tipoEntradasDtos, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TipoEntradaDTO tipoEntradaDTO){
        if (tipoEntradaDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().body("Nombre nulo");
        }

        Object object = tipoEntradaService.save(TipoEntrada.builder()
                        .nombre(tipoEntradaDTO.getNombre())
                        .porcentajeAdicional(tipoEntradaDTO.getPorcentajeAdicional())
                .build());

        if (object instanceof TipoEntrada) {
            TipoEntrada tipoEntrada = (TipoEntrada) object;
            return new ResponseEntity<>("Evento creado con exito id: " + tipoEntrada.getId(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(object, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<TipoEntrada> tipoEntrada = tipoEntradaService.findById(id);
        if (tipoEntrada.isPresent()) {
            tipoEntradaService.deleteById(id);
            return new ResponseEntity<>("Tipo de entrada eliminada con exito", HttpStatus.OK);
        }

        return new ResponseEntity<>("Tipo de entrada no encontrada", HttpStatus.NOT_FOUND);
    }
}
