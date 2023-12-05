package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.ItinerarioDTO;
import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;

import java.util.List;

public interface ItinerarioService {
    void crearItinerario(ItinerarioDTO itinerarioDTO);
    void eliminarItinerario(Long idItinerario);
    List<ItinerarioEntity> listarItinerarios();
    void modificarItinerario(Long idItinerario, ItinerarioDTO itinerarioDTO);

    ItinerarioEntity obtenerItinerarioPorId(Long idItinerario);
}
