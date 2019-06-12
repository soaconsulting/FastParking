package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the paises database table.
 * 
 */
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPais;
	private String codigo;
	private String nombre;

	public Pais() {
	}

	public Long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
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