package com.viajaplus.ViajaPlus.Service.ServiceImpl;

import com.viajaplus.ViajaPlus.DTO.ItinerarioDTO;
import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;
import com.viajaplus.ViajaPlus.Repository.ItinerarioRepository;
import com.viajaplus.ViajaPlus.Service.ItinerarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class ItinerarioServiceImpl implements ItinerarioService {

    private ItinerarioRepository itinerarioRepository;

    @Autowired
    public ItinerarioServiceImpl(ItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    @Override
    public void crearItinerario(ItinerarioDTO itinerarioDTO) {
        itinerarioRepository.save(new ItinerarioEntity(itinerarioDTO.getOrigen(), itinerarioDTO.getDestino(),
                Time.valueOf(itinerarioDTO.getSalida() + ":00"), Time.valueOf(itinerarioDTO.getLlegada() + ":00")));
    }

    @Override
    public void eliminarItinerario(Long idItinerario) {
        itinerarioRepository.deleteById(idItinerario);
    }

    @Override
    public List<ItinerarioEntity> listarItinerarios() {
        /*List<ItinerarioEntity> itinerarios = itinerarioRepository.findAll();
        for (ItinerarioEntity itinerario : itinerarios) {
            itinerario.setSalida(Time.valueOf(itinerario.getSalida().toLocalTime()));
            itinerario.setLlegada(Time.valueOf(itinerario.getLlegada().toLocalTime()));
        }
        return itinerarios;*/
        return itinerarioRepository.findAll();
    }

    @Override
    public void modificarItinerario(Long idItinerario, ItinerarioDTO itinerarioDTO) {
        ItinerarioEntity itinerarioExistente = itinerarioRepository.findById(idItinerario).orElseThrow(EntityNotFoundException::new);
        itinerarioExistente.setOrigen(itinerarioDTO.getOrigen());
        itinerarioExistente.setDestino(itinerarioDTO.getDestino());
        itinerarioExistente.setSalida(Time.valueOf(itinerarioDTO.getSalida() + ":00"));
        itinerarioExistente.setLlegada(Time.valueOf(itinerarioDTO.getLlegada() + ":00"));
        itinerarioRepository.save(itinerarioExistente);
    }

    @Override
    public ItinerarioEntity obtenerItinerarioPorId(Long idItinerario) {
        return itinerarioRepository.findById(idItinerario).orElseThrow(EntityNotFoundException::new);
    }
}
