package com.plataformaEventos.persistence;

import com.plataformaEventos.entiti.CodigoPromocional;

import java.util.List;
import java.util.Optional;

public interface ICodigoPromocionalDAO {
    List<CodigoPromocional> findAll();

    Optional<CodigoPromocional> findById(long id);

    CodigoPromocional save(CodigoPromocional CodigoPromocional);

    void deleteById(long id);
}
