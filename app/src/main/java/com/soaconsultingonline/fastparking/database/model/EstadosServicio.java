package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the estados_servicio database table.
 * 
 */
public class EstadosServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idEstadoServicio;
	private String codigo;
	private String nombre;

	public EstadosServicio() {
	}

	public Long getIdEstadoServicio() {
		return this.idEstadoServicio;
	}

	public void setIdEstadoServicio(Long idEstadoServicio) {
		this.idEstadoServicio = idEstadoServicio;
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