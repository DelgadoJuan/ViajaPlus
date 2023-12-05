package com.viajaplus.ViajaPlus.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
public class ServicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itinerario_id")
    private ItinerarioEntity itinerario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programador_dni")
    private ProgramadorEntity programador;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transporte_id")
    private TransporteEntity transporte;
    @OneToMany(mappedBy = "servicio", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<VentaEntity> ventas;
    @OneToMany(mappedBy = "servicio", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ReservaEntity> reservas;
    private LocalDate partida;
    private LocalDate llegada;
    private double costo;

    public ServicioEntity() {
    }

    public ServicioEntity(ItinerarioEntity itinerario, ProgramadorEntity programadorEntity, TransporteEntity transporte, LocalDate partida, LocalDate llegada, double costo) {
        this.itinerario = itinerario;
        this.programador = programadorEntity;
        this.transporte = transporte;
        this.partida = partida;
        this.llegada = llegada;
        this.costo = costo;
        this.reservas = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public ServicioEntity(Long id, ItinerarioEntity itinerario, ProgramadorEntity programadorEntity,
                          TransporteEntity transporte, List<VentaEntity> ventas,
                          LocalDate partida, LocalDate llegada, double costo, List<ReservaEntity> reservas) {
        this.id = id;
        this.itinerario = itinerario;
        this.programador = programadorEntity;
        this.transporte = transporte;
        this.ventas = ventas;
        this.reservas = reservas;
        this.partida = partida;
        this.llegada = llegada;
        this.costo = costo;
    }

    public ProgramadorEntity getProgramador() {
        return programador;
    }

    public void setProgramador(ProgramadorEntity programador) {
        this.programador = programador;
    }

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItinerarioEntity getItinerario() {
        return itinerario;
    }

    public void setItinerario(ItinerarioEntity itinerario) {
        this.itinerario = itinerario;
    }

    public ProgramadorEntity getProgramadorEntity() {
        return programador;
    }

    public void setProgramadorEntity(ProgramadorEntity programadorEntity) {
        this.programador = programadorEntity;
    }

    public TransporteEntity getTransporte() {
        return transporte;
    }

    public void setTransporte(TransporteEntity transporte) {
        this.transporte = transporte;
    }

    public List<VentaEntity> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaEntity> ventas) {
        this.ventas = ventas;
    }

    public LocalDate getPartida() {
        return partida;
    }

    public void setPartida(LocalDate partida) {
        this.partida = partida;
    }

    public LocalDate getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalDate llegada) {
        this.llegada = llegada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
