package com.plataformaEventos.service.Impl;

import com.plataformaEventos.controller.dto.CodigoPromocionalDTO;
import com.plataformaEventos.controller.dto.EventosDTO;
import com.plataformaEventos.entiti.CodigoPromocional;
import com.plataformaEventos.entiti.Eventos;
import com.plataformaEventos.persistence.ICodigoPromocionalDAO;
import com.plataformaEventos.persistence.IEventosDAO;
import com.plataformaEventos.service.ICodigoPromocionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodigoPromocionalServiceImpl implements ICodigoPromocionalService {

    @Autowired
    private ICodigoPromocionalDAO codigoPromocionalDAO;

    @Autowired
    private IEventosDAO eventosDAO;

    @Override
    public List<CodigoPromocional> findAll() {
        return codigoPromocionalDAO.findAll();
    }

    @Override
    public Optional<CodigoPromocional> findById(long id) {
        return codigoPromocionalDAO.findById(id);
    }

    @Override
    public CodigoPromocionalDTO save(CodigoPromocional codigoPromocional) {


        Eventos evento = eventosDAO.findById(codigoPromocional.getEvento().getId()).orElse(null);

        // Primero guarda el evento si no está guardado
        if (codigoPromocional.getEvento() != null && evento != null) {
            codigoPromocional.setEvento(evento);
        }
        CodigoPromocional codigoPromocional1 = codigoPromocionalDAO.save(codigoPromocional);
        return CodigoPromocionalDTO.builder()
                .id(codigoPromocional1.getId())
                .codigo(codigoPromocional1.getCodigo())
                .activo(codigoPromocional1.isActivo())
                .fechaInicio(codigoPromocional1.getFechaInicio())
                .fechaFin(codigoPromocional1.getFechaFin())
                .descuento(codigoPromocional1.getDescuento())
                .evento(EventosDTO.builder()
                        .titulo(codigoPromocional1.getEvento().getTitulo())
                        .descripcion(codigoPromocional1.getEvento().getDescripcion())
                        .fecha(codigoPromocional1.getEvento().getFecha())
                        .hora(codigoPromocional1.getEvento().getHora())
                        .lugar(codigoPromocional1.getEvento().getLugar())
                        .cupoDisponible(codigoPromocional1.getEvento().getCupoDisponible())
                        .tipo(codigoPromocional1.getEvento().isTipo())
                        .valorBase(codigoPromocional1.getEvento().getValorBase())
                        .categoria(codigoPromocional1.getEvento().getCategoria())
                        .capacidadEvento(codigoPromocional1.getEvento().getCapacidadEvento())
                        .fechaApertura(codigoPromocional1.getEvento().getFechaApertura())
                        .fechaCierre(codigoPromocional1.getEvento().getFechaCierre())
                        .opcionCompra(codigoPromocional1.getEvento().isOpcionCompra())
                        .build())
                .build();
    }

    @Override
    public void deleteById(long id) {
        codigoPromocionalDAO.deleteById(id);
    }
}
