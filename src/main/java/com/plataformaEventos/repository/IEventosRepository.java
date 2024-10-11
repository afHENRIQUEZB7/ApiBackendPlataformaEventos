package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.Eventos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEventosRepository extends CrudRepository<Eventos, Long> {
    List<Eventos> findByOpcionCompraTrue();
}
