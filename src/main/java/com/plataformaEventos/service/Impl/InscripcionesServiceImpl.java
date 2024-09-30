package com.plataformaEventos.service.Impl;

import com.plataformaEventos.entiti.Inscripciones;
import com.plataformaEventos.persistence.IInscripcionesDAO;
import com.plataformaEventos.repository.IInscripcionesRepository;
import com.plataformaEventos.service.IInscripcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesServiceImpl implements IInscripcionesService {

    @Autowired
    private IInscripcionesDAO iInscripcionesDAO;

    @Override
    public List<Inscripciones> findAll() {
        return (List<Inscripciones>) iInscripcionesDAO.findAll();
    }

    @Override
    public Optional<Inscripciones> findById(Long id) {
        return iInscripcionesDAO.findById(id);
    }

    @Override
    public void save(Inscripciones inscripciones) {
        iInscripcionesDAO.save(inscripciones);
    }

    @Override
    public void deleteById(long id) {
        iInscripcionesDAO.deleteById(id);
    }

    @Override
    public List<Inscripciones> filtrarPorIdAsistente(Long id) {
        return iInscripcionesDAO.filtrarPorIdAsistente(id);
    }

    @Override
    public List<Inscripciones> filtrarPorIdEvento(Long id) {
        return iInscripcionesDAO.filtrarPorIdEvento(id);
    }
}
