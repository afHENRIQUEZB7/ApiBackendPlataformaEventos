package com.plataformaEventos.service.Impl;

import com.plataformaEventos.entiti.TipoEntrada;
import com.plataformaEventos.persistence.ITipoEntradaDAO;
import com.plataformaEventos.repository.ITipoEntradaRepository;
import com.plataformaEventos.service.ITipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TipoEntradaServiceImpl implements ITipoEntradaService {

    // Definición del mapa estático
    private static final Map<String, Integer> mapTiposEntrada;

    // Inicialización del mapa en un bloque estático
    static {
        mapTiposEntrada = new HashMap<>();
        mapTiposEntrada.put("Gratis", 0);
        mapTiposEntrada.put("General", 15);
        mapTiposEntrada.put("VIP", 30);
    }

    @Autowired
    private ITipoEntradaDAO iTipoEntradaDAO;

    @Override
    public List<TipoEntrada> findAll() {
        return (List<TipoEntrada>) iTipoEntradaDAO.findAll();
    }

    @Override
    public Optional<TipoEntrada> findById(long id) {
        return iTipoEntradaDAO.findById(id);
    }

    @Override
    public Object save(TipoEntrada tipoEntrada) {
        String tipo = tipoEntrada.getNombre();
        double porcentaje = tipoEntrada.getPorcentajeAdicional();

        String mensaje = "";

        List<TipoEntrada> listaTiposEntrada = iTipoEntradaDAO.findAll();
        if (listaTiposEntrada.size()>3) {
            mensaje = "Ya no se aceptan más tipos de entrada \n" +
                    "los tipos de entradas son: \n" +
                    listaTiposEntrada;
            return mensaje;
        }

        for (Map.Entry<String, Integer> entry : mapTiposEntrada.entrySet()) {
            if (tipo.equalsIgnoreCase(entry.getKey())) {
                if(porcentaje == entry.getValue()) {
                    return iTipoEntradaDAO.save(tipoEntrada);
                }
                mensaje = "El valor de porcentaje no esta deacurdo con el tipo de la entrada, recuerde que los tipos " +
                        "de entradas son con los siguientes porcentajes: " +
                        "\n*-- Gratis 0% --*\n" +
                        "*-- General 15% --*\n" +
                        "*-- VIP 30% --*\n ";
                return mensaje;
            }
            mensaje = "El tipo de entrada ingresado no esta permitido recuede que los tipos de entradas son con los siguientes procentajes: " +
                    "\n*-- Gratis 0% --*\n" +
                    "*-- General 15% --*\n" +
                    "*-- VIP 30% --*\n ";
        }
        return mensaje;
    }

    @Override
    public void deleteById(long id) {
        iTipoEntradaDAO.findById(id);
    }
}
