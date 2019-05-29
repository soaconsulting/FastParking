package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ParametroParqueadero implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public ParametroParqueadero() {
    }

    private Long idParametro;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal valorMinuto;
    private String tarifaPlena;
    private BigDecimal horasTarifaPlena;
    private BigDecimal valorTarifaPlena;
    private Parqueadero parqueadero;

    /**
     * @return the idParametro
     */
    public Long getIdParametro() {
        return idParametro;
    }

    /**
     * @param idParametro the idParametro to set
     */
    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the valorMinuto
     */
    public BigDecimal getValorMinuto() {
        return valorMinuto;
    }

    /**
     * @param valorMinuto the valorMinuto to set
     */
    public void setValorMinuto(BigDecimal valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    /**
     * @return the tarifaPlena
     */
    public String getTarifaPlena() {
        return tarifaPlena;
    }

    /**
     * @param tarifaPlena the tarifaPlena to set
     */
    public void setTarifaPlena(String tarifaPlena) {
        this.tarifaPlena = tarifaPlena;
    }

    /**
     * @return the horasTarifaPlena
     */
    public BigDecimal getHorasTarifaPlena() {
        return horasTarifaPlena;
    }

    /**
     * @param horasTarifaPlena the horasTarifaPlena to set
     */
    public void setHorasTarifaPlena(BigDecimal horasTarifaPlena) {
        this.horasTarifaPlena = horasTarifaPlena;
    }

    /**
     * @return the valorTarifaPlena
     */
    public BigDecimal getValorTarifaPlena() {
        return valorTarifaPlena;
    }

    /**
     * @param valorTarifaPlena the valorTarifaPlena to set
     */
    public void setValorTarifaPlena(BigDecimal valorTarifaPlena) {
        this.valorTarifaPlena = valorTarifaPlena;
    }

    /**
     * @return the parqueadero
     */
    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    /**
     * @param parqueadero the parqueadero to set
     */
    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }
}
