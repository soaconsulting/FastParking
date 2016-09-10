package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private String codigoTicket;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Date fechaServicio;
	private String numeroFactura;
	private String placa;
	private BigDecimal tiempoMinutos;
	private BigDecimal valorFactura;
	private List<Pago> pagos;
	private List<Pqr> pqrs;
	private List<HistorialEstadosServicio> historialEstadosServicio;
	private Parqueadero parqueadero;
	private Usuario usuario;

	public ServiciosParqueadero() {
	}

	public Long getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getCodigoEan() {
		return this.codigoEan;
	}

	public void setCodigoEan(String codigoEan) {
		this.codigoEan = codigoEan;
	}

	public String getCodigoTicket() {
		return this.codigoTicket;
	}

	public void setCodigoTicket(String codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaServicio() {
		return this.fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public String getNumeroFactura() {
		return this.numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getTiempoMinutos() {
		return this.tiempoMinutos;
	}

	public void setTiempoMinutos(BigDecimal tiempoMinutos) {
		this.tiempoMinutos = tiempoMinutos;
	}

	public BigDecimal getValorFactura() {
		return this.valorFactura;
	}

	public void setValorFactura(BigDecimal valorFactura) {
		this.valorFactura = valorFactura;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setServiciosParqueadero(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setServiciosParqueadero(null);

		return pago;
	}

	public List<Pqr> getPqrs() {
		return this.pqrs;
	}

	public void setPqrs(List<Pqr> pqrs) {
		this.pqrs = pqrs;
	}

	public Pqr addPqr(Pqr pqr) {
		getPqrs().add(pqr);
		pqr.setServiciosParqueadero(this);

		return pqr;
	}

	public Pqr removePqr(Pqr pqr) {
		getPqrs().remove(pqr);
		pqr.setServiciosParqueadero(null);

		return pqr;
	}

	public Parqueadero getParqueadero() {
		return this.parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the historialEstadosServicio
	 */
	public List<HistorialEstadosServicio> getHistorialEstadosServicio() {
		return historialEstadosServicio;
	}

	/**
	 * @param historialEstadosServicio the historialEstadosServicio to set
	 */
	public void setHistorialEstadosServicio(
			List<HistorialEstadosServicio> historialEstadosServicio) {
		this.historialEstadosServicio = historialEstadosServicio;
	}

}