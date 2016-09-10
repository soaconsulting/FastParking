package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the estados_notific database table.
 * 
 */
public class EstadosNotific implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idEstadoNotific;
	private String codigo;
	private String nombre;

	public EstadosNotific() {
	}

	public Long getIdEstadoNotific() {
		return this.idEstadoNotific;
	}

	public void setIdEstadoNotific(Long idEstadoNotific) {
		this.idEstadoNotific = idEstadoNotific;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}