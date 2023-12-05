package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByDni(String dni);
}
