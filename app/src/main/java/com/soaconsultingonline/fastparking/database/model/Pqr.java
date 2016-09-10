package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the pqrs database table.
 * 
 */
public class Pqr implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPqrs;
	private String comentarios;
	private Date fechaPqrs;
	private String numero;
	private MotivosPqr motivosPqr;
	private ServiciosParqueadero serviciosParqueadero;

	public Pqr() {
	}

	public Long getIdPqrs() {
		return this.idPqrs;
	}

	public void setIdPqrs(Long idPqrs) {
		this.idPqrs = idPqrs;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaPqrs() {
		return this.fechaPqrs;
	}

	public void setFechaPqrs(Date fechaPqrs) {
		this.fechaPqrs = fechaPqrs;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public MotivosPqr getMotivosPqr() {
		return this.motivosPqr;
	}

	public void setMotivosPqr(MotivosPqr motivosPqr) {
		this.motivosPqr = motivosPqr;
	}

	public ServiciosParqueadero getServiciosParqueadero() {
		return this.serviciosParqueadero;
	}

	public void setServiciosParqueadero(ServiciosParqueadero serviciosParqueadero) {
		this.serviciosParqueadero = serviciosParqueadero;
	}

}