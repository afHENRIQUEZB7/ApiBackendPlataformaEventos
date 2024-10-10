package com.plataformaEventos.service;

import com.plataformaEventos.controller.dto.CodigoPromocionalDTO;
import com.plataformaEventos.entiti.CodigoPromocional;

import java.util.List;
import java.util.Optional;

public interface ICodigoPromocionalService {
    List<CodigoPromocional> findAll();

    Optional<CodigoPromocional> findById(long id);

    CodigoPromocionalDTO save(CodigoPromocional CodigoPromocional);

    void deleteById(long id);
}
