package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the ciudades database table.
 * 
 */
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idCiudad;
	private String codigo;
	private String nombre;
	private Departamento departamento;
	private List<Parqueadero> parqueaderos;

	public Ciudad() {
	}

	public Long getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
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

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Parqueadero> getParqueaderos() {
		return this.parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}

	public Parqueadero addParqueadero(Parqueadero parqueadero) {
		getParqueaderos().add(parqueadero);
		parqueadero.setCiudade(this);

		return parqueadero;
	}

	public Parqueadero removeParqueadero(Parqueadero parqueadero) {
		getParqueaderos().remove(parqueadero);
		parqueadero.setCiudade(null);

		return parqueadero;
	}

}