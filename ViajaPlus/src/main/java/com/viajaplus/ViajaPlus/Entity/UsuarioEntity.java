package com.viajaplus.ViajaPlus.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viajaplus.ViajaPlus.DTO.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    private String dni;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotEmpty
    private String nombre;
    @Email(message = "Email no válido", regexp="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    @Column(unique = true)
    @NotEmpty(message = "El campo email es obligatorio")
    private String email;
    @NotEmpty
    @Column(unique = true)
    private String telefono;
    private LocalDate fechaNacimiento;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private Rol rol;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento, LocalDateTime fechaCreacion, Rol rol) {
        this.dni = dni;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.rol = rol;
    }

    public UsuarioEntity(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = Rol.ROLE_CLIENTE;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(dni, that.dni) && Objects.equals(password, that.password) && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(telefono, that.telefono) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(fechaCreacion, that.fechaCreacion) && rol == that.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, password, nombre, email, telefono, fechaNacimiento, fechaCreacion, rol);
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaCreacion=" + fechaCreacion +
                ", rol=" + rol +
                '}';
    }
}
