package com.plataformaEventos.persistence;

import com.plataformaEventos.entiti.Inscripciones;

import java.util.List;
import java.util.Optional;

public interface IInscripcionesDAO {

    List<Inscripciones> findAll();

    Optional<Inscripciones> findById(Long id);

    void save(Inscripciones inscripciones);

    void deleteById(long id);

    List<Inscripciones> filtrarPorIdAsistente(Long id);

    List<Inscripciones> filtrarPorIdEvento(Long id);

}
