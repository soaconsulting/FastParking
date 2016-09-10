package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the medios_pago database table.
 * 
 */
public class MediosPago implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idMediosPago;
	private String codigo;
	private String nombre;

	public MediosPago() {
	}

	public Long getIdMediosPago() {
		return this.idMediosPago;
	}

	public void setIdMediosPago(Long idMediosPago) {
		this.idMediosPago = idMediosPago;
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