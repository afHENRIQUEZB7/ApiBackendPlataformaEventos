package com.plataformaEventos.persistence;

import com.plataformaEventos.entiti.Eventos;

import java.util.List;
import java.util.Optional;

public interface IEventosDAO {
    List<Eventos> findAll();

    Optional<Eventos> findById(long id);

    Eventos save(Eventos eventos);

    void deleteById(long id);


}
