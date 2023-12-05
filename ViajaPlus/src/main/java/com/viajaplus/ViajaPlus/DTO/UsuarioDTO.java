package com.viajaplus.ViajaPlus.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UsuarioDTO {
    private String dni;
    private String password;
    @NotEmpty
    private String nombre;
    @Email(message = "Email no válido", regexp="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    @NotEmpty(message = "El campo email es obligatorio")
    private String email;
    @NotEmpty
    private String telefono;
    private LocalDate fechaNacimiento;

    public UsuarioDTO(String dni, String password, String nombre, String email, String telefono, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(dni, that.dni) && Objects.equals(password, that.password) && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(telefono, that.telefono) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, password, nombre, email, telefono, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
