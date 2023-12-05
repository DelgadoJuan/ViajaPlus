package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.ClienteEntity;
import com.viajaplus.ViajaPlus.Entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByCliente(ClienteEntity cliente);
}
