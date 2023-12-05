package com.viajaplus.ViajaPlus.Entity;

import com.viajaplus.ViajaPlus.DTO.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "programador")
public class ProgramadorEntity extends UsuarioEntity {
    @OneToMany(mappedBy = "programador", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ServicioEntity> servicios;

    public ProgramadorEntity() {
    }

    public ProgramadorEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento, LocalDateTime fechaCreacion, Rol rol, List<ServicioEntity> servicios) {
        super(dni, password, nombre, email, telefono, fechaNacimiento, fechaCreacion, rol);
        this.servicios = servicios;
    }

    public ProgramadorEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento) {
        super(dni, password, nombre, email, telefono, fechaNacimiento);
        this.servicios = new ArrayList<>();
        this.setRol(Rol.ROLE_PROGRAMADOR);
    }

    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProgramadorEntity that = (ProgramadorEntity) o;
        return Objects.equals(servicios, that.servicios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), servicios);
    }
}
