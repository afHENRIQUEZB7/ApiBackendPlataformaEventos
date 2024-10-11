package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.Inscripciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface IInscripcionesRepository extends CrudRepository<Inscripciones, Long> {
    List<Inscripciones> findByAsistenteId(Long asistenteId);
    List<Inscripciones> findByEventoId(Long eventoId);
}
