package com.plataformaEventos.service.Impl;

import com.plataformaEventos.entiti.Asistentes;
import com.plataformaEventos.persistence.IAsistentesDAO;
import com.plataformaEventos.service.IAsistentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistentesServiceImpl implements IAsistentesService {

    @Autowired
    private  IAsistentesDAO asistentesDAO;

    @Override
    public List<Asistentes> findAll() {
        return asistentesDAO.findAll();
    }

    @Override
    public void save(Asistentes asistentes) {
        asistentesDAO.save(asistentes);
    }

    @Override
    public void deleteById(long id) {
        asistentesDAO.deleteById(id);
    }

    @Override
    public Optional<Asistentes> findById(long id) {
        return asistentesDAO.findById(id);
    }
    @Override
    public List<Asistentes> filtrarPorNombre(String nombre) {
        return asistentesDAO.filtrarPorNombre(nombre);
    }

    @Override
    public List<Asistentes> filtrarPorApellido(String apellido) {
        return asistentesDAO.filtrarPorApellido(apellido);
    }
}
