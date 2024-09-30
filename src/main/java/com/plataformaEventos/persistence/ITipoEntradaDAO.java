package com.plataformaEventos.persistence;

import com.plataformaEventos.entiti.TipoEntrada;

import java.util.List;
import java.util.Optional;

public interface ITipoEntradaDAO {
    List<TipoEntrada> findAll();

    Optional<TipoEntrada> findById(long id);

    Object save(TipoEntrada eventos);

    void deleteById(long id);
}
