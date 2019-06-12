package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;

public class EstadoRedencion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idEstadoRedencion;
    private String codigo;
    private String nombre;

    public EstadoRedencion() {
    }

    public Long getIdEstadoRedencion() {
        return idEstadoRedencion;
    }

    public void setIdEstadoRedencion(Long idEstadoRedencion) {
        this.idEstadoRedencion = idEstadoRedencion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
