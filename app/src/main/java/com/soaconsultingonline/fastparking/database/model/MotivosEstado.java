package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the motivos_estado database table.
 * 
 */
public class MotivosEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idMotivoEstado;
	private String codigo;
	private String nombre;

	public MotivosEstado() {
	}

	public Long getIdMotivoEstado() {
		return this.idMotivoEstado;
	}

	public void setIdMotivoEstado(Long idMotivoEstado) {
		this.idMotivoEstado = idMotivoEstado;
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