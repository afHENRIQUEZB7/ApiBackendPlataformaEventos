package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.TipoEntrada;
import com.plataformaEventos.persistence.ITipoEntradaDAO;
import com.plataformaEventos.repository.ITipoEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class TipoEntradaDaoImpl implements ITipoEntradaDAO {

    @Autowired
    private ITipoEntradaRepository tipoEntradaRepository;

    @Override
    public List<TipoEntrada> findAll() {
        return (List<TipoEntrada>) tipoEntradaRepository.findAll();
    }

    @Override
    public Optional<TipoEntrada> findById(long id) {
        return tipoEntradaRepository.findById(id);
    }

    @Override
    public Object save(TipoEntrada eventos) {
        return tipoEntradaRepository.save(eventos);
    }

    @Override
    public void deleteById(long id) {
        tipoEntradaRepository.findById(id);
    }
}
