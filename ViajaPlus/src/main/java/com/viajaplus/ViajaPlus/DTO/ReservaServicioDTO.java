package com.viajaplus.ViajaPlus.DTO;

import com.viajaplus.ViajaPlus.Entity.ServicioEntity;

public class ReservaServicioDTO {
    private Long reservaId;
    private ServicioEntity servicio;

    public ReservaServicioDTO(Long reservaId, ServicioEntity servicio) {
        this.reservaId = reservaId;
        this.servicio = servicio;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }
}
