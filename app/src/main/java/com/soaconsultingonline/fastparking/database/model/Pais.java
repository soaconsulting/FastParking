package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the paises database table.
 * 
 */
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPais;
	private String codigo;
	private String nombre;
	private List<Departamento> departamentos;

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

	public List<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setPais(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setPais(null);

		return departamento;
	}

}