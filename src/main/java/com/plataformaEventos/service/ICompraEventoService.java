package com.plataformaEventos.service;

import com.plataformaEventos.entiti.CompraEvento;

import java.util.List;
import java.util.Optional;

public interface ICompraEventoService {
    List<CompraEvento> findAll();

    Optional<CompraEvento> findById(long id);

    CompraEvento save(CompraEvento eventos);

    void deleteById(long id);
}
