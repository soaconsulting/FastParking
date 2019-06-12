package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class RedencionPuntos implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idRedencion;
    private Timestamp fechaRedencion;
    private BigDecimal puntosRedimidos;
    private ServiciosParqueadero servicioParqueadero;
    private EstadoRedencion estadoRedencion;
    private ConceptoRedencion conceptoRedencion;

    public RedencionPuntos() {
    }

    public Long getIdRedencion() {
        return idRedencion;
    }

    public void setIdRedencion(Long idRedencion) {
        this.idRedencion = idRedencion;
    }

    public Timestamp getFechaRedencion() {
        return fechaRedencion;
    }

    public void setFechaRedencion(Timestamp fechaRedencion) {
        this.fechaRedencion = fechaRedencion;
    }

    public BigDecimal getPuntosRedimidos() {
        return puntosRedimidos;
    }

    public void setPuntosRedimidos(BigDecimal puntosRedimidos) {
        this.puntosRedimidos = puntosRedimidos;
    }

    public ServiciosParqueadero getServicioParqueadero() {
        return servicioParqueadero;
    }

    public void setServicioParqueadero(ServiciosParqueadero servicioParqueadero) {
        this.servicioParqueadero = servicioParqueadero;
    }

    public EstadoRedencion getEstadoRedencion() {
        return estadoRedencion;
    }

    public void setEstadoRedencion(EstadoRedencion estadoRedencion) {
        this.estadoRedencion = estadoRedencion;
    }

    public ConceptoRedencion getConceptoRedencion() {
        return conceptoRedencion;
    }

    public void setConceptoRedencion(ConceptoRedencion conceptoRedencion) {
        this.conceptoRedencion = conceptoRedencion;
    }
}
