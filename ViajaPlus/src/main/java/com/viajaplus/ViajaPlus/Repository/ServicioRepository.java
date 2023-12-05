package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> {
    @Query("SELECT s FROM ServicioEntity s JOIN s.itinerario i WHERE i.origen = :origen AND i.destino = :destino")
    List<ServicioEntity> findByItinerarioOrigenAndItinerarioDestino(@Param("origen") String origen, @Param("destino") String destino);
}

