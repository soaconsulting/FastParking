package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the tipos_auth database table.
 * 
 */
public class TiposAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idTipoAuth;
	private String codigo;
	private String nombre;

	public TiposAuth() {
	}

	public Long getIdTipoAuth() {
		return this.idTipoAuth;
	}

	public void setIdTipoAuth(Long idTipoAuth) {
		this.idTipoAuth = idTipoAuth;
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