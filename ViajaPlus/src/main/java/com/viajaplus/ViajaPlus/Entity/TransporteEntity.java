package com.viajaplus.ViajaPlus.Entity;

import com.viajaplus.ViajaPlus.DTO.Categoria;
import com.viajaplus.ViajaPlus.DTO.TipoAtencion;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transporte")
public class TransporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String empresa;
    private int cantidadAsientos;
    private Boolean dosPisos;
    private Categoria categoria;
    @OneToMany(mappedBy = "transporte", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ServicioEntity> serviciosActivos;
    private TipoAtencion tipoAtencion;

    public TransporteEntity() {
    }

    public TransporteEntity(String nombre, String empresa, int cantidadAsientos, Boolean dosPisos, Categoria categoria, TipoAtencion tipoAtencion) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.cantidadAsientos = cantidadAsientos;
        this.dosPisos = dosPisos;
        this.categoria = categoria;
        this.tipoAtencion = tipoAtencion;
        this.serviciosActivos = new ArrayList<>();
    }

    public TransporteEntity(Long id, String nombre, String empresa, int cantidadAsientos, Boolean dosPisos,
                            Categoria categoria, List<ServicioEntity> serviciosActivos, TipoAtencion tipoAtencion) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.cantidadAsientos = cantidadAsientos;
        this.dosPisos = dosPisos;
        this.categoria = categoria;
        this.serviciosActivos = serviciosActivos;
        this.tipoAtencion = tipoAtencion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ServicioEntity> getServiciosActivos() {
        return serviciosActivos;
    }

    public void setServiciosActivos(List<ServicioEntity> serviciosActivos) {
        this.serviciosActivos = serviciosActivos;
    }

    public TipoAtencion getTipoAtencion() {
        return tipoAtencion;
    }

    public void setTipoAtencion(TipoAtencion tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public double costoCategoria() {
        if (this.categoria.equals(Categoria.Comun)) {
            return 8000;
        } else if (this.categoria.equals(Categoria.Semicama)) {
            return 12000;
        }
        return 15000;
    }

    public double costoTipoAtencion() {
        if (this.tipoAtencion.equals(TipoAtencion.Comun)) {
            return 5000;
        }
        return 10000;
    }

    @Override
    public String toString() {
        return "TransporteEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                ", cantidadAsientos=" + cantidadAsientos +
                ", dosPisos=" + dosPisos +
                ", categoria=" + categoria +
                ", serviciosActivos=" + serviciosActivos +
                ", tipoAtencion=" + tipoAtencion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransporteEntity that = (TransporteEntity) o;
        return cantidadAsientos == that.cantidadAsientos && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(empresa, that.empresa) && Objects.equals(dosPisos, that.dosPisos) && categoria == that.categoria && Objects.equals(serviciosActivos, that.serviciosActivos) && tipoAtencion == that.tipoAtencion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empresa, cantidadAsientos, dosPisos, categoria, serviciosActivos, tipoAtencion);
    }
}
