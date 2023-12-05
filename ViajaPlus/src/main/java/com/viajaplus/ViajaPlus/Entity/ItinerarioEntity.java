package com.viajaplus.ViajaPlus.Entity;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "itinerario")
public class ItinerarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origen;
    private String destino;
    private Time salida;
    private Time llegada;

    public ItinerarioEntity() {
    }

    public ItinerarioEntity(Long id, String origen, String destino, Time salida, Time llegada) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.llegada = llegada;
    }

    public ItinerarioEntity(String origen, String destino, Time salida, Time llegada) {
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.llegada = llegada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getSalida() {
        return salida;
    }

    public void setSalida(Time salida) {
        this.salida = salida;
    }

    public Time getLlegada() {
        return llegada;
    }

    public void setLlegada(Time llegada) {
        this.llegada = llegada;
    }

    @Override
    public String toString() {
        return this.origen + " - " + this.destino;
    }
}
