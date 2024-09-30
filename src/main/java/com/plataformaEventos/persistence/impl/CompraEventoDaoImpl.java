package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.CompraEvento;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.persistence.ICompraEventoDAO;
import com.plataformaEventos.persistence.IEventosDAO;
import com.plataformaEventos.repository.ICompraEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompraEventoDaoImpl implements ICompraEventoDAO {

    @Autowired
    private ICompraEventoRepository compraEventoRepository;


    @Override
    public List<CompraEvento> findAll() {
        return (List<CompraEvento>) compraEventoRepository.findAll();
    }

    @Override
    public Optional<CompraEvento> findById(long id) {
        return compraEventoRepository.findById(id);
    }

    @Override
    public CompraEvento save(CompraEvento eventos) {
        return compraEventoRepository.save(eventos);
    }

    @Override
    public void deleteById(long id) {
        compraEventoRepository.deleteById(id);
    }
}
