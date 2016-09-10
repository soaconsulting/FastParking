package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the motivos_pqrs database table.
 * 
 */
public class MotivosPqr implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idMotivoPqrs;
	private String codigo;
	private String nombre;

	public MotivosPqr() {
	}

	public Long getIdMotivoPqrs() {
		return this.idMotivoPqrs;
	}

	public void setIdMotivoPqrs(Long idMotivoPqrs) {
		this.idMotivoPqrs = idMotivoPqrs;
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