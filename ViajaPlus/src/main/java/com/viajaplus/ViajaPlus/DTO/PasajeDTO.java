package com.viajaplus.ViajaPlus.DTO;

public class PasajeDTO {
    private String clienteId;
    private Long servicioId;

    public PasajeDTO(String clienteId, Long servicioId) {
        this.clienteId = clienteId;
        this.servicioId = servicioId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setCliente(String clienteId) {
        this.clienteId = clienteId;
    }

    public Long getServicio() {
        return servicioId;
    }

    public void setServicio(Long servicioId) {
        this.servicioId = servicioId;
    }
}
