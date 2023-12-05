package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.ClienteEntity;
import com.viajaplus.ViajaPlus.Entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
    List<VentaEntity> findByCliente(ClienteEntity cliente);
}
