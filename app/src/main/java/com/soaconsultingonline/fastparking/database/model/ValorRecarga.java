package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ValorRecarga implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idOpcion;
    private String codigo;
    private String nombre;
    private BigDecimal valor;

    public ValorRecarga() {
    }

    public Long getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
