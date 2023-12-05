package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.ItinerarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItinerarioRepository extends JpaRepository<ItinerarioEntity, Long> {
}
