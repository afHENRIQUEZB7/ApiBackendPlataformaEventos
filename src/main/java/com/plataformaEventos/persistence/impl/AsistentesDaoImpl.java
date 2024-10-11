package com.plataformaEventos.persistence.impl;

import com.plataformaEventos.entiti.Asistentes;
import com.plataformaEventos.persistence.IAsistentesDAO;
import com.plataformaEventos.repository.IAsistentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AsistentesDaoImpl implements IAsistentesDAO {

    public AsistentesDaoImpl(IAsistentesRepository asistentesRepository) {
        this.asistentesRepository = asistentesRepository;
    }

    private final IAsistentesRepository asistentesRepository;


    @Override
    public List<Asistentes> findAll() {
        return (List<Asistentes>) asistentesRepository.findAll();
    }

    @Override
    public void save(Asistentes asistentes) {
        asistentesRepository.save(asistentes);
    }

    @Override
    public void deleteById(long id) {
        asistentesRepository.deleteById(id);
    }

    @Override
    public Optional<Asistentes> findById(long id) {
        return asistentesRepository.findById(id);
    }

    @Override
    public List<Asistentes> filtrarPorNombre(String nombre) {
        return asistentesRepository.findByNombresContainingIgnoreCase(nombre);
    }

    @Override
    public List<Asistentes> filtrarPorApellido(String apellido) {
        return asistentesRepository.findByApellidosContainingIgnoreCase(apellido);
    }
}
