package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.Inscripciones;
import com.plataformaEventos.persistence.IInscripcionesDAO;
import com.plataformaEventos.repository.IInscripcionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class InscripcionesDaoImpl implements IInscripcionesDAO {

    @Autowired
    private IInscripcionesRepository inscripcionesRepository;

    @Override
    public List<Inscripciones> findAll() {
        return (List<Inscripciones>) inscripcionesRepository.findAll();
    }

    @Override
    public Optional<Inscripciones> findById(Long id) {
        return inscripcionesRepository.findById(id);
    }

    @Override
    public void save(Inscripciones inscripciones) {
        inscripcionesRepository.save(inscripciones);
    }

    @Override
    public void deleteById(long id) {
        inscripcionesRepository.deleteById(id);
    }

    @Override
    public List<Inscripciones> filtrarPorIdAsistente(Long id) {
        return inscripcionesRepository.findByAsistenteId(id);
    }

    @Override
    public List<Inscripciones> filtrarPorIdEvento(Long id) {
        return inscripcionesRepository.findByEventoId(id);
    }
}
