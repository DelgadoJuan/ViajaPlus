package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.ServicioDTO;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;

import java.util.List;

public interface ServicioService {
    void crearServicio(ServicioDTO servicioDTO);
    void eliminarServicio(Long idServicio);
    List<ServicioEntity> listarTodos();
    ServicioEntity obtenerServicioPorId(Long idServicio);
    void modificarServicio(Long idServicio, ServicioDTO servicioDTO);
    List<ServicioEntity> filtrarPorItinerarioOrigenYDestino(String origen, String destino);
}
