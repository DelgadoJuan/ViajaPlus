package com.viajaplus.ViajaPlus.Service;

import java.time.LocalDate;
import java.util.Map;

public interface EstadisticaService {
    Map<String, Long> estadisticaItinerario();
    Map<LocalDate, Long> obtenerEstadisticasPasajesPorFechaOrdenDescendente();
    Map<String, Long> obtenerEstadisticasPasajesPorCategoriaUnidadesOrdenDescendente();
}
