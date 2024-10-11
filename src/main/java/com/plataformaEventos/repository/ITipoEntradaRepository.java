package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.TipoEntrada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEntradaRepository extends CrudRepository<TipoEntrada, Long> {
}
