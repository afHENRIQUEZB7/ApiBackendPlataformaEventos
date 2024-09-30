package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.CodigoPromocional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICodigoPromocionalRepository extends CrudRepository<CodigoPromocional, Long> {
    List<CodigoPromocional> findByEventoIdAndActivoTrue(Long eventoId);
}
