package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the parqueaderos database table.
 * 
 */
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idParqueadero;
	private String activo;
	private String cargoPersonaContacto;
	private String celular;
	private String direccion;
	private String email;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private String nombre;
	private String personaContacto;
	private String telefono;
	private Ciudad ciudade;
	private Empresa empresa;
	private String codigoParqueadero;

	public Parqueadero() {
	}

	public Long getIdParqueadero() {
		return this.idParqueadero;
	}

	public void setIdParqueadero(Long idParqueadero) {
		this.idParqueadero = idParqueadero;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCargoPersonaContacto() {
		return this.cargoPersonaContacto;
	}

	public void setCargoPersonaContacto(String cargoPersonaContacto) {
		this.cargoPersonaContacto = cargoPersonaContacto;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getLatitud() {
		return this.latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return this.longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPersonaContacto() {
		return this.personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudade() {
		return this.ciudade;
	}

	public void setCiudade(Ciudad ciudade) {
		this.ciudade = ciudade;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCodigoParqueadero() {
		return codigoParqueadero;
	}

	public void setCodigoParqueadero(String codigoParqueadero) {
		this.codigoParqueadero = codigoParqueadero;
	}

}