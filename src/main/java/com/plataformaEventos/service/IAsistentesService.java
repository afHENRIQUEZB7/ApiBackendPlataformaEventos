package com.plataformaEventos.service;

import com.plataformaEventos.entiti.Asistentes;
import com.plataformaEventos.entiti.Eventos;

import java.util.List;
import java.util.Optional;

public interface IAsistentesService {

    List<Asistentes> findAll();

    void save(Asistentes asistentes);

    void deleteById(long id);

    Optional<Asistentes> findById(long id);

    List<Asistentes> filtrarPorNombre(String nombre);

    List<Asistentes> filtrarPorApellido(String apellido);
}
