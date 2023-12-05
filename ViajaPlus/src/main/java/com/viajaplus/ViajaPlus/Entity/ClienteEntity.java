package com.viajaplus.ViajaPlus.Entity;

import com.viajaplus.ViajaPlus.DTO.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends UsuarioEntity{
    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<VentaEntity> pasajes;

    public ClienteEntity() {
    }

    public ClienteEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento, List<VentaEntity> pasajes) {
        super(dni, password, nombre, email, telefono, fechaNacimiento);
        this.pasajes = pasajes;
    }

    public ClienteEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento) {
        super(dni, password, nombre, email, telefono, fechaNacimiento);
        this.pasajes = new ArrayList<>();
        this.setRol(Rol.ROLE_CLIENTE);
    }

    public List<VentaEntity> getReservas() {
        return pasajes;
    }

    public void setReservas(List<VentaEntity> reservas) {
        this.pasajes = reservas;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "reservas=" + pasajes +
                '}';
    }
}
