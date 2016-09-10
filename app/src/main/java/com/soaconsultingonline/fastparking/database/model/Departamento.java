package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the departamentos database table.
 * 
 */
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDepto;

	private String codigo;
	private String nombre;
	private List<Ciudad> ciudades;
	private Pais pais;

	public Departamento() {
	}

	public Long getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(Long idDepto) {
		this.idDepto = idDepto;
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

	public List<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setDepartamento(this);

		return ciudade;
	}

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setDepartamento(null);

		return ciudade;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}