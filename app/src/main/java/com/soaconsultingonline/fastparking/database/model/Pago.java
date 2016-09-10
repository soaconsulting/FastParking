package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pagos database table.
 * 
 */
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPago;
	private Date fechaPago;
	private BigDecimal valorPagado;
	private EstadosPago estadosPago;
	private MediosPago mediosPago;
	private ServiciosParqueadero serviciosParqueadero;
	private Usuario usuario;
	private PuntosGanados puntosGanado;

	public Pago() {
	}

	public Long getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getValorPagado() {
		return this.valorPagado;
	}

	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	public EstadosPago getEstadosPago() {
		return this.estadosPago;
	}

	public void setEstadosPago(EstadosPago estadosPago) {
		this.estadosPago = estadosPago;
	}

	public MediosPago getMediosPago() {
		return this.mediosPago;
	}

	public void setMediosPago(MediosPago mediosPago) {
		this.mediosPago = mediosPago;
	}

	public ServiciosParqueadero getServiciosParqueadero() {
		return this.serviciosParqueadero;
	}

	public void setServiciosParqueadero(ServiciosParqueadero serviciosParqueadero) {
		this.serviciosParqueadero = serviciosParqueadero;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PuntosGanados getPuntosGanado() {
		return this.puntosGanado;
	}

	public void setPuntosGanado(PuntosGanados puntosGanado) {
		this.puntosGanado = puntosGanado;
	}

}