package com.viajaplus.ViajaPlus.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_dni")
    private ClienteEntity cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicio_id")
    private ServicioEntity servicio;
    private double costo;

    public ReservaEntity() {
    }

    public ReservaEntity(ClienteEntity clienteEntity, ServicioEntity servicio) {
        this.cliente = clienteEntity;
        this.servicio = servicio;
        this.costo = servicio.getCosto();
    }

    public ReservaEntity(Long id, ClienteEntity clienteEntity, ServicioEntity servicio, double costo) {
        this.id = id;
        this.cliente = clienteEntity;
        this.servicio = servicio;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicioEntity(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
