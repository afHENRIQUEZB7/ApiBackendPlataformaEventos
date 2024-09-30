package com.plataformaEventos.service;

import com.plataformaEventos.entiti.Inscripciones;

import java.util.List;
import java.util.Optional;

public interface IInscripcionesService {

    List<Inscripciones> findAll();

    Optional<Inscripciones> findById(Long id);

    void save(Inscripciones inscripciones);

    void deleteById(long id);

    List<Inscripciones> filtrarPorIdAsistente(Long id);

    List<Inscripciones> filtrarPorIdEvento(Long id);
}
