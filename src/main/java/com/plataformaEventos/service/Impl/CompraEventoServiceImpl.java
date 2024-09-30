package com.plataformaEventos.service.Impl;

import com.plataformaEventos.entiti.CompraEvento;
import com.plataformaEventos.persistence.ICompraEventoDAO;
import com.plataformaEventos.service.ICompraEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraEventoServiceImpl implements ICompraEventoService {

    @Autowired
    private ICompraEventoDAO iCompraEventoDAO;

    @Override
    public List<CompraEvento> findAll() {
        return iCompraEventoDAO.findAll();
    }

    @Override
    public Optional<CompraEvento> findById(long id) {
        return iCompraEventoDAO.findById(id);
    }

    @Override
    public CompraEvento save(CompraEvento eventos) {
        return iCompraEventoDAO.save(eventos);
    }

    @Override
    public void deleteById(long id) {
        iCompraEventoDAO.deleteById(id);
    }
}
