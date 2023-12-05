package com.viajaplus.ViajaPlus.Repository;

import com.viajaplus.ViajaPlus.Entity.ProgramadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorRepository extends JpaRepository<ProgramadorEntity, String> {
}
