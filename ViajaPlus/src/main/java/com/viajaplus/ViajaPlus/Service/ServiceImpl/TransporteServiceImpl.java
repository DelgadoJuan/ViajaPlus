package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.TransporteDTO;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Entity.TransporteEntity;
import com.viajaplus.ViajaPlus.Repository.TransporteRepository;
import com.viajaplus.ViajaPlus.Service.TransporteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransporteServiceImpl implements TransporteService {

    private TransporteRepository transporteRepository;

    @Autowired
    public TransporteServiceImpl(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    @Override
    public void crearTransporte(TransporteDTO transporteDTO) {
        transporteRepository.save(new TransporteEntity(transporteDTO.getNombre(), transporteDTO.getEmpresa(),
                transporteDTO.getCantidadAsientos(), transporteDTO.getDosPisos(), transporteDTO.getCategoria(),
                transporteDTO.getTipoAtencion()));
    }

    @Override
    public void eliminarTransporte(Long idTransporte) {
        transporteRepository.deleteById(idTransporte);
    }

    @Override
    public void modificarTransporte(Long idTransporte, TransporteDTO transporteDTO) {
        TransporteEntity transporteExistente = transporteRepository.findById(idTransporte).orElseThrow(EntityNotFoundException::new);
        transporteExistente.setNombre(transporteDTO.getNombre());
        transporteExistente.setEmpresa(transporteDTO.getEmpresa());
        transporteExistente.setCantidadAsientos(transporteDTO.getCantidadAsientos());
        transporteExistente.setDosPisos(transporteDTO.getDosPisos());
        transporteExistente.setCategoria(transporteDTO.getCategoria());
        transporteExistente.setTipoAtencion(transporteDTO.getTipoAtencion());
        transporteRepository.save(transporteExistente);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void eliminarServiciosTerminados() {
        List<TransporteEntity> transportes = transporteRepository.findAll();

        for (TransporteEntity transporte : transportes) {
            List<ServicioEntity> servicios = transporte.getServiciosActivos();
            List<ServicioEntity> serviciosTerminados = servicios.stream()
                    .filter(this::servicioHaTerminado)
                    .toList();

            servicios.removeAll(serviciosTerminados);
        }

        // Guarda los transportes actualizados en la base de datos
        transporteRepository.saveAll(transportes);
    }

    @Override
    public List<TransporteEntity> listarTransportes() {
        return transporteRepository.findAll();
    }

    @Override
    public TransporteEntity obtenerPorId(Long idTransporte) {
        return transporteRepository.findById(idTransporte).orElseThrow(EntityNotFoundException::new);
    }

    private boolean servicioHaTerminado(ServicioEntity servicio) {
        return servicio.getLlegada().isBefore(LocalDate.now());
    }
}
