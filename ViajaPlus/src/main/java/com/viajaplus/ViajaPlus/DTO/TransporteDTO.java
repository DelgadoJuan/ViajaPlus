package com.viajaplus.ViajaPlus.DTO;

import jakarta.validation.constraints.NotEmpty;

public class TransporteDTO {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String empresa;
    private int cantidadAsientos;
    private Boolean dosPisos;
    private Categoria categoria;
    private TipoAtencion tipoAtencion;

    public TransporteDTO(String nombre, String empresa, int cantidadAsientos, Boolean dosPisos, Categoria categoria, TipoAtencion tipoAtencion) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.cantidadAsientos = cantidadAsientos;
        this.dosPisos = dosPisos;
        this.categoria = categoria;
        this.tipoAtencion = tipoAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public Boolean getDosPisos() {
        return dosPisos;
    }

    public void setDosPisos(Boolean dosPisos) {
        this.dosPisos = dosPisos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoAtencion getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(TipoAtencion tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }
}
