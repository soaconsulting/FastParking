package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;


/**
 * The persistent class for the conceptos_inventario database table.
 * 
 */
public class ConceptosInventario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idConceptoInventario;
	private String codigo;
	private String nombre;

	public ConceptosInventario() {
	}

	public Long getIdConceptoInventario() {
		return this.idConceptoInventario;
	}

	public void setIdConceptoInventario(Long idConceptoInventario) {
		this.idConceptoInventario = idConceptoInventario;
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