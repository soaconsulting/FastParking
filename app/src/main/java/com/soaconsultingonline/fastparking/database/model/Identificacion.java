package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the identificaciones database table.
 * 
 */
public class Identificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idIdentificacion;
	private String codigo;
	private String nombre;

	public Identificacion() {
	}

	public Long getIdIdentificacion() {
		return this.idIdentificacion;
	}

	public void setIdIdentificacion(Long idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
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