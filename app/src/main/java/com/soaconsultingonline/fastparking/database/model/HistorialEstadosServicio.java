package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the historial_estados_servicio database table.
 * 
 */
public class HistorialEstadosServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idHistorial;
	private Date fechaEstado;
	private EstadosServicio estadosServicio;
	private MotivosEstado motivosEstado;
	private ServiciosParqueadero serviciosParqueadero;

	public HistorialEstadosServicio() {
	}

	public Long getIdHistorial() {
		return this.idHistorial;
	}

	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Date getFechaEstado() {
		return this.fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public EstadosServicio getEstadosServicio() {
		return this.estadosServicio;
	}

	public void setEstadosServicio(EstadosServicio estadosServicio) {
		this.estadosServicio = estadosServicio;
	}

	public MotivosEstado getMotivosEstado() {
		return this.motivosEstado;
	}

	public void setMotivosEstado(MotivosEstado motivosEstado) {
		this.motivosEstado = motivosEstado;
	}

	public ServiciosParqueadero getServiciosParqueadero() {
		return this.serviciosParqueadero;
	}

	public void setServiciosParqueadero(ServiciosParqueadero serviciosParqueadero) {
		this.serviciosParqueadero = serviciosParqueadero;
	}

}