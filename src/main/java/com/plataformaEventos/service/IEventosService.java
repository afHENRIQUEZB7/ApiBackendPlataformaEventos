package com.plataformaEventos.service;

import com.plataformaEventos.entiti.Eventos;

import java.util.List;
import java.util.Optional;

public interface IEventosService {

    List<Eventos> findAll();

    Optional<Eventos> findById(long id);

    Eventos save(Eventos eventos);

    void deleteById(long id);

    List<Eventos> filtrarOpcioncompra();
}
