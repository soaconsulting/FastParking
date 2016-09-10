package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the estados_pago database table.
 * 
 */
public class EstadosPago implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idEstadosPago;
	private String codigo;
	private String nombre;

	public EstadosPago() {
	}

	public Long getIdEstadosPago() {
		return this.idEstadosPago;
	}

	public void setIdEstadosPago(Long idEstadosPago) {
		this.idEstadosPago = idEstadosPago;
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