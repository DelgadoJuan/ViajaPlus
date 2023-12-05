package com.viajaplus.ViajaPlus.DTO;

public class EstadisticaItinerarioDTO {
    private Long id;
    private String origen;
    private String destino;
    private int cantidad;

    public EstadisticaItinerarioDTO(Long id, String origen, String destino, int cantidad) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
