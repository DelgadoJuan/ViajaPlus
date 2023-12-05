package com.viajaplus.ViajaPlus.Service;

import com.viajaplus.ViajaPlus.DTO.PasajeDTO;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;

import java.util.List;

public interface PasajeService {
    boolean comprarPasaje(PasajeDTO pasajeDTO);
    List<ServicioEntity> listarVentas(String clienteDni);
}
