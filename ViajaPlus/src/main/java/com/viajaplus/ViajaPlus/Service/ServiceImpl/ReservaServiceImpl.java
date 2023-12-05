package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.PasajeDTO;
import com.viajaplus.ViajaPlus.Entity.ClienteEntity;
import com.viajaplus.ViajaPlus.Entity.ReservaEntity;
import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import com.viajaplus.ViajaPlus.Entity.VentaEntity;
import com.viajaplus.ViajaPlus.Repository.ClienteRepository;
import com.viajaplus.ViajaPlus.Repository.ReservaRepository;
import com.viajaplus.ViajaPlus.Repository.ServicioRepository;
import com.viajaplus.ViajaPlus.Repository.VentaRepository;
import com.viajaplus.ViajaPlus.Service.ReservaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    private ServicioRepository servicioRepository;
    private ClienteRepository clienteRepository;
    private ReservaRepository reservaRepository;
    private VentaRepository ventaRepository;

    @Autowired
    public ReservaServiceImpl(ServicioRepository servicioRepository, ClienteRepository clienteRepository, ReservaRepository reservaRepository, VentaRepository ventaRepository) {
        this.servicioRepository = servicioRepository;
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public boolean reservar(PasajeDTO pasajeDTO) {
        ServicioEntity servicio = servicioRepository.findById(pasajeDTO.getServicio()).orElseThrow(EntityNotFoundException::new);
        if (servicio.getVentas().size() < servicio.getTransporte().getCantidadAsientos()) {
            ClienteEntity cliente = clienteRepository.findById(pasajeDTO.getClienteId()).orElseThrow(EntityNotFoundException::new);
            reservaRepository.save(new ReservaEntity(cliente, servicio));
            return true;
        }
        return false;
    }

    @Override
    public void pagarReserva(Long idReserva) {
        ReservaEntity reserva = reservaRepository.findById(idReserva).orElseThrow(EntityNotFoundException::new);
        ventaRepository.save(new VentaEntity(reserva.getCliente(), reserva.getServicio()));
        reservaRepository.delete(reserva);
    }

    @Override
    public List<ReservaEntity> listarReservas(String dni) {
        ClienteEntity cliente = clienteRepository.findById(dni).orElseThrow(EntityNotFoundException::new);
        return reservaRepository.findByCliente(cliente);
    }

    @Override
    public void cancelarReserva(Long idReserva) throws EntityNotFoundException {
        reservaRepository.deleteById(idReserva);
    }

    @Scheduled(fixedRate = 60000) // Ejecutar cada minuto (ajusta según sea necesario)
    public void eliminarReservasCaducadas() {
        LocalDateTime ahora = LocalDateTime.now();

        List<ReservaEntity> reservas = reservaRepository.findAll();

        for (ReservaEntity reserva : reservas) {
            LocalDateTime limiteCaducidad = reserva.getServicio().getPartida().atStartOfDay().minusMinutes(30);

            // Verificar si la reserva ha caducado
            if (ahora.isAfter(limiteCaducidad)) {
                reservaRepository.delete(reserva);
            }
        }
    }

}
