package com.plataformaEventos.repository;

import com.plataformaEventos.entiti.Asistentes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface IAsistentesRepository extends CrudRepository<Asistentes, Long> {

    List<Asistentes> findByNombresContainingIgnoreCase(String nombre);
    List<Asistentes> findByApellidosContainingIgnoreCase(String apellido);
}
