package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the motivos_bajas database table.
 * 
 */
public class MotivosBaja implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idMotivoBajas;
	private String codigo;
	private String nombre;

	public MotivosBaja() {
	}

	public Long getIdMotivoBajas() {
		return this.idMotivoBajas;
	}

	public void setIdMotivoBajas(Long idMotivoBajas) {
		this.idMotivoBajas = idMotivoBajas;
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