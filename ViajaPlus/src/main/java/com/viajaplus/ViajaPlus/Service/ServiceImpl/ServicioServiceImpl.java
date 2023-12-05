package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.ServicioDTO;
import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;
import com.viajaplus.ViajaPlus.Entity.ProgramadorEntity;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Entity.TransporteEntity;
import com.viajaplus.ViajaPlus.Repository.ItinerarioRepository;
import com.viajaplus.ViajaPlus.Repository.ProgramadorRepository;
import com.viajaplus.ViajaPlus.Repository.ServicioRepository;
import com.viajaplus.ViajaPlus.Repository.TransporteRepository;
import com.viajaplus.ViajaPlus.Service.ServicioService;
import com.viajaplus.ViajaPlus.Service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private ItinerarioRepository itinerarioRepository;
    private ProgramadorRepository programadorRepository;
    private TransporteRepository transporteRepository;
    private ServicioRepository servicioRepository;
    private UsuarioService usuarioService;

    @Autowired
    public ServicioServiceImpl(ItinerarioRepository itinerarioRepository, ProgramadorRepository programadorRepository, TransporteRepository transporteRepository, ServicioRepository servicioRepository, UsuarioService usuarioService) {
        this.itinerarioRepository = itinerarioRepository;
        this.programadorRepository = programadorRepository;
        this.transporteRepository = transporteRepository;
        this.servicioRepository = servicioRepository;
        this.usuarioService = usuarioService;
    }

    public void crearServicio(ServicioDTO servicioDTO) {
        ItinerarioEntity itinerario = itinerarioRepository.findById(servicioDTO.getItinerarioId()).orElseThrow(EntityNotFoundException::new);
        ProgramadorEntity programador = programadorRepository.findById(usuarioService.obtenerClientIdDelUsuarioLogueado()).orElseThrow(EntityNotFoundException::new);
        TransporteEntity transporte = transporteRepository.findById(servicioDTO.getTransporteId()).orElseThrow(EntityNotFoundException::new);
        servicioRepository.save(new ServicioEntity(itinerario, programador,
                transporte, servicioDTO.getPartida(), servicioDTO.getLlegada(), servicioDTO.getCosto()));
    }

    @Override
    public void eliminarServicio(Long idServicio) {
        servicioRepository.deleteById(idServicio);
    }

    @Override
    public List<ServicioEntity> listarTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public ServicioEntity obtenerServicioPorId(Long idServicio) {
        return servicioRepository.findById(idServicio).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void modificarServicio(Long idServicio, ServicioDTO servicioDTO) {
        ServicioEntity servicioExistente = obtenerServicioPorId(idServicio);
        TransporteEntity transporte = transporteRepository.findById(servicioDTO.getTransporteId()).orElseThrow(EntityNotFoundException::new);
        ItinerarioEntity itinerario = itinerarioRepository.findById(servicioDTO.getItinerarioId()).orElseThrow(EntityNotFoundException::new);
        servicioExistente.setItinerario(itinerario);
        servicioExistente.setTransporte(transporte);
        servicioExistente.setPartida(servicioDTO.getPartida());
        servicioExistente.setLlegada(servicioDTO.getLlegada());
        servicioExistente.setCosto(servicioDTO.getCosto() + transporte.costoTipoAtencion() + transporte.costoCategoria());
        servicioRepository.save(servicioExistente);
    }

    public List<ServicioEntity> filtrarPorItinerarioOrigenYDestino(String origen, String destino) {
        return servicioRepository.findByItinerarioOrigenAndItinerarioDestino(origen, destino);
    }

}
