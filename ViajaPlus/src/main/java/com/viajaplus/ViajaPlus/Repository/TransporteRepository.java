package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.TransporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<TransporteEntity, Long> {
}
