package com.plataformaEventos.persistence;

import com.plataformaEventos.entiti.CompraEvento;
import com.plataformaEventos.entiti.TipoEntrada;

import java.util.List;
import java.util.Optional;

public interface ICompraEventoDAO {
    List<CompraEvento> findAll();

    Optional<CompraEvento> findById(long id);

    CompraEvento save(CompraEvento eventos);

    void deleteById(long id);
}
