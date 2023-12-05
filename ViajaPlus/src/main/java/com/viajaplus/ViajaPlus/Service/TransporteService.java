package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.TransporteDTO;
import com.viajaplus.ViajaPlus.Entity.TransporteEntity;

import java.util.List;

public interface TransporteService {
    void crearTransporte(TransporteDTO transporteDTO);
    void eliminarTransporte(Long idTransporte);
    void modificarTransporte(Long idTransporte, TransporteDTO transporteDTO);
    void eliminarServiciosTerminados();
    List<TransporteEntity> listarTransportes();

    TransporteEntity obtenerPorId(Long idTransporte);
}
