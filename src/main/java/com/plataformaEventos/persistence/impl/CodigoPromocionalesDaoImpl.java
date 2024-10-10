package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.CodigoPromocional;
import com.plataformaEventos.persistence.ICodigoPromocionalDAO;
import com.plataformaEventos.repository.ICodigoPromocionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CodigoPromocionalesDaoImpl implements ICodigoPromocionalDAO {

    @Autowired
    private ICodigoPromocionalRepository codigoPromocionalRepository;

    @Override
    public List<CodigoPromocional> findAll() {
        return (List<CodigoPromocional>) codigoPromocionalRepository.findAll();
    }

    @Override
    public Optional<CodigoPromocional> findById(long id) {
        return codigoPromocionalRepository.findById(id);
    }

    @Override
    public CodigoPromocional save(CodigoPromocional CodigoPromocional) {
        return codigoPromocionalRepository.save(CodigoPromocional);
    }

    @Override
    public void deleteById(long id) {
        codigoPromocionalRepository.deleteById(id);
    }
}
