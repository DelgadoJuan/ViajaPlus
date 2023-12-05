package com.viajaplus.ViajaPlus.DTO;

public class ItinerarioDTO {
    private String origen;
    private String destino;
    private String salida;
    private String llegada;

    public ItinerarioDTO(String origen, String destino, String salida, String llegada) {
        this.origen = origen;
        this.destino = destino;
        this.salida = salida;
        this.llegada = llegada;
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

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }
}
