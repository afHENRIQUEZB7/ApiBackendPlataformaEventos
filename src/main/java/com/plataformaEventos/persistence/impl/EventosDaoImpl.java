package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.persistence.IEventosDAO;
import com.plataformaEventos.repository.IEventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class EventosDaoImpl implements IEventosDAO {

    @Autowired
    private IEventosRepository eventosRepository;

    @Override
    public List<Eventos> findAll() {
        return (List<Eventos>) eventosRepository.findAll();
    }

    @Override
    public Optional<Eventos> findById(long id) {
        return eventosRepository.findById( id);
    }

    @Override
    public Eventos save(Eventos eventos) {
        Eventos eventosCreado = eventosRepository.save(eventos);
        return eventosCreado;
    }

    @Override
    public void deleteById(long id) {
        eventosRepository.deleteById(id);
    }
}
