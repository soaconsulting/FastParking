package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CompraPuntos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCompra;
    private Timestamp fechaCompra;
    private BigDecimal valorPagado;
    private EstadosPago estadosPago;
    private MediosPago mediosPago;
    private Usuario usuario;
    private PuntosComprados puntosComprados;
    private ValorRecarga valorRecarga;
    private String refTransaccion;

    public CompraPuntos() {
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Timestamp fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    public EstadosPago getEstadosPago() {
        return estadosPago;
    }

    public void setEstadosPago(EstadosPago estadosPago) {
        this.estadosPago = estadosPago;
    }

    public MediosPago getMediosPago() {
        return mediosPago;
    }

    public void setMediosPago(MediosPago mediosPago) {
        this.mediosPago = mediosPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PuntosComprados getPuntosComprados() {
        return puntosComprados;
    }

    public void setPuntosComprados(PuntosComprados puntosComprados) {
        this.puntosComprados = puntosComprados;
    }

    public ValorRecarga getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(ValorRecarga valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public String getRefTransaccion() {
        return refTransaccion;
    }

    public void setRefTransaccion(String refTransaccion) {
        this.refTransaccion = refTransaccion;
    }
}
