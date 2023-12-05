package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.PasajeDTO;
import com.viajaplus.ViajaPlus.Entity.ClienteEntity;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Entity.VentaEntity;
import com.viajaplus.ViajaPlus.Repository.ClienteRepository;
import com.viajaplus.ViajaPlus.Repository.ServicioRepository;
import com.viajaplus.ViajaPlus.Repository.VentaRepository;
import com.viajaplus.ViajaPlus.Service.PasajeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasajeServiceImpl implements PasajeService {

    private ClienteRepository clienteRepository;
    private ServicioRepository servicioRepository;
    private VentaRepository ventaRepository;

    @Autowired
    public PasajeServiceImpl(ClienteRepository clienteRepository, ServicioRepository servicioRepository,
                             VentaRepository ventaRepository) {
        this.clienteRepository = clienteRepository;
        this.servicioRepository = servicioRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public boolean comprarPasaje(PasajeDTO pasajeDTO) {
        ServicioEntity servicio = servicioRepository.findById(pasajeDTO.getServicio()).orElseThrow(EntityNotFoundException::new);
        if (servicio.getVentas().size() < servicio.getTransporte().getCantidadAsientos()) {
            ClienteEntity cliente = clienteRepository.findById(pasajeDTO.getClienteId()).orElseThrow(EntityNotFoundException::new);
            ventaRepository.save(new VentaEntity(cliente, servicio));
            return true;
        }
        return false;
    }

    @Override
    public List<ServicioEntity> listarVentas(String clienteDni) {
        LocalDate fechaActual = LocalDate.now();
        ClienteEntity cliente = clienteRepository.findById(clienteDni).orElseThrow(EntityNotFoundException::new);
        return ventaRepository.findByCliente(cliente).stream().map(VentaEntity::getServicio)
                .filter(servicio -> servicio.getPartida().isAfter(fechaActual))
                .collect(Collectors.toList());
    }
}
