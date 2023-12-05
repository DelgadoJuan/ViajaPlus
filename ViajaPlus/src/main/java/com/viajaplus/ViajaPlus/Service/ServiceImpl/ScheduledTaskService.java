package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.Service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
    @Autowired
    private TransporteService transporteService;

    @Scheduled(fixedRate = 86400000) // Ejecutar cada 24 horas
    public void eliminarServiciosTerminadosProgramado() {
        transporteService.eliminarServiciosTerminados();
    }
}
