package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.CompraEvento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ICompraEventoRepository extends CrudRepository<CompraEvento, Long> {
}
