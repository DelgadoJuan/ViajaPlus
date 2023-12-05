package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Repository.ServicioRepository;
import com.viajaplus.ViajaPlus.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {

    private ServicioRepository servicioRepository;

    @Autowired
    public EstadisticaServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Map<String, Long> estadisticaItinerario() {
        List<ServicioEntity> servicios = servicioRepository.findAll();
        Map<String, Long> estadisticas = new HashMap<>();

        for (ServicioEntity servicio : servicios) {
            String nombreItinerario = obtenerNombreItinerario(servicio.getItinerario());

            // Incrementar el contador de pasajes vendidos para el itinerario
            estadisticas.put(nombreItinerario, estadisticas.getOrDefault(nombreItinerario, 0L) + servicio.getVentas().size());
        }

        // Ordenar el mapa por valor en orden descendente
        return estadisticas.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<LocalDate, Long> obtenerEstadisticasPasajesPorFechaOrdenDescendente() {
        List<ServicioEntity> servicios = servicioRepository.findAll();
        Map<LocalDate, Long> estadisticas = new HashMap<>();

        for (ServicioEntity servicio : servicios) {
            LocalDate fecha = servicio.getPartida();

            // Incrementar el contador de pasajes vendidos para la fecha
            estadisticas.put(fecha, estadisticas.getOrDefault(fecha, 0L) + servicio.getVentas().size());
        }

        // Ordenar el mapa por cantidad en orden descendente
        return estadisticas.entrySet().stream()
                .sorted(Map.Entry.<LocalDate, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Map<String, Long> obtenerEstadisticasPasajesPorCategoriaUnidadesOrdenDescendente() {
        List<ServicioEntity> servicios = servicioRepository.findAll();
        Map<String, Long> estadisticas = new HashMap<>();

        for (ServicioEntity servicio : servicios) {
            String categoriaUnidades = String.valueOf(servicio.getTransporte().getCategoria()); // Puedes ajustar esto según tus necesidades

            // Incrementar el contador de pasajes vendidos para la categoría de unidades
            estadisticas.put(categoriaUnidades, estadisticas.getOrDefault(categoriaUnidades, 0L) + servicio.getVentas().size());
        }

        // Ordenar el mapa por valor en orden descendente
        return estadisticas.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private String obtenerNombreItinerario(ItinerarioEntity itinerario) {
        // Lógica para obtener una representación del nombre del itinerario,
        // por ejemplo, concatenar origen y destino
        return itinerario.getOrigen() + " - " + itinerario.getDestino();
    }
}
