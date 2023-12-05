package com.viajaplus.ViajaPlus.DTO;

import java.time.LocalDate;

public class ServicioDTO {
    private Long itinerarioId;
    private Long transporteId;
    private LocalDate partida;
    private LocalDate llegada;
    private double costo;

    public ServicioDTO(Long itinerarioId, Long transporteId, LocalDate partida, LocalDate llegada, double costo) {
        this.itinerarioId = itinerarioId;
        this.transporteId = transporteId;
        this.partida = partida;
        this.llegada = llegada;
        this.costo = costo;
    }

    public Long getItinerarioId() {
        return itinerarioId;
    }

    public void setItinerarioId(Long itinerarioId) {
        this.itinerarioId = itinerarioId;
    }

    public Long getTransporteId() {
        return transporteId;
    }

    public void setTransporteId(Long transporteId) {
        this.transporteId = transporteId;
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
