package com.plataformaEventos.service.Impl;

import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.persistence.IEventosDAO;
import com.plataformaEventos.service.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventosServiceImpl implements IEventosService {

    @Autowired
    private IEventosDAO eventosDAO;

    @Override
    public List<Eventos> findAll() {
        return eventosDAO.findAll();
    }

    @Override
    public Optional<Eventos> findById(long id) {
        return eventosDAO.findById(id);
    }

    @Override
    public Eventos save(Eventos eventos) {
        Eventos eventosCreado = eventosDAO.save(eventos);
        return eventosCreado;
    }

    @Override
    public void deleteById(long id) {
        eventosDAO.deleteById(id);
    }
}
