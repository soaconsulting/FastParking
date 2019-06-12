package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the servicios_parqueadero database table.
 * 
 */
public class ServiciosParqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idServicio;
	private String codigoEan;
	private String codigoQR;
	private Timestamp fechaIngreso;
	private Timestamp fechaSalida;
	private Date fechaServicio;
	private String numeroFactura;
	private String placa;
	private BigDecimal tiempoMinutos;
	private BigDecimal valorFactura; // totalBruto - Descuento + Impuestos
	private List<Pqr> pqrs;
	private List<HistorialEstadosServicio> historialEstadosServicio;
	private List<RedencionPuntos> redencionPuntos;
	private Parqueadero parqueadero;
	private Usuario usuario;
	private BigDecimal totalBruto; // minutos * valorMinuto
	private BigDecimal descuento;
	private BigDecimal impuestos;
	private BigDecimal valorPP; // Valor que cobra la plataforma
	private BigDecimal impuestosPP; // Impuesto por facturar en la plataforma
	private BigDecimal totalPagar; // valorFactura + valorPP + impuestosPP

	public ServiciosParqueadero() {
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getCodigoEan() {
		return codigoEan;
	}

	public void setCodigoEan(String codigoEan) {
		this.codigoEan = codigoEan;
	}

	public String getCodigoQR() {
		return codigoQR;
	}

	public void setCodigoQR(String codigoQR) {
		this.codigoQR = codigoQR;
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getTiempoMinutos() {
		return tiempoMinutos;
	}

	public void setTiempoMinutos(BigDecimal tiempoMinutos) {
		this.tiempoMinutos = tiempoMinutos;
	}

	public BigDecimal getValorFactura() {
		return valorFactura;
	}

	public void setValorFactura(BigDecimal valorFactura) {
		this.valorFactura = valorFactura;
	}

	public List<Pqr> getPqrs() {
		return pqrs;
	}

	public void setPqrs(List<Pqr> pqrs) {
		this.pqrs = pqrs;
	}

	public List<HistorialEstadosServicio> getHistorialEstadosServicio() {
		return historialEstadosServicio;
	}

	public void setHistorialEstadosServicio(List<HistorialEstadosServicio> historialEstadosServicio) {
		this.historialEstadosServicio = historialEstadosServicio;
	}

	public List<RedencionPuntos> getRedencionPuntos() {
		return redencionPuntos;
	}

	public void setRedencionPuntos(List<RedencionPuntos> redencionPuntos) {
		this.redencionPuntos = redencionPuntos;
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getTotalBruto() {
		return totalBruto;
	}

	public void setTotalBruto(BigDecimal totalBruto) {
		this.totalBruto = totalBruto;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(BigDecimal impuestos) {
		this.impuestos = impuestos;
	}

	public BigDecimal getValorPP() {
		return valorPP;
	}

	public void setValorPP(BigDecimal valorPP) {
		this.valorPP = valorPP;
	}

	public BigDecimal getImpuestosPP() {
		return impuestosPP;
	}

	public void setImpuestosPP(BigDecimal impuestosPP) {
		this.impuestosPP = impuestosPP;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}
}