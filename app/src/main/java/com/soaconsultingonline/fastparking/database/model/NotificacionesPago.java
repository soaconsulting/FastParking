package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the notificaciones_pago database table.
 * 
 */
public class NotificacionesPago implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idNotificacionPago;

	private String comentarios;
	private Date fechaNotificacion;
	private EstadosNotific estadosNotific;
	private Pago pago;

	public NotificacionesPago() {
	}

	public Long getIdNotificacionPago() {
		return this.idNotificacionPago;
	}

	public void setIdNotificacionPago(Long idNotificacionPago) {
		this.idNotificacionPago = idNotificacionPago;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaNotificacion() {
		return this.fechaNotificacion;
	}

	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	public EstadosNotific getEstadosNotific() {
		return this.estadosNotific;
	}

	public void setEstadosNotific(EstadosNotific estadosNotific) {
		this.estadosNotific = estadosNotific;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}