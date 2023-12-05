package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.PasajeDTO;
import com.viajaplus.ViajaPlus.Entity.ReservaEntity;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface ReservaService {
    boolean reservar(PasajeDTO pasajeDTO);
    void cancelarReserva(Long idReserva) throws EntityNotFoundException;
    void eliminarReservasCaducadas();
    void pagarReserva(Long idReserva);
    List<ReservaEntity> listarReservas(String clienteDni);
}
