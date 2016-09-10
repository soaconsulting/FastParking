package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the empresas database table.
 * 
 */
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idEmpresa;
	private String activo;
	private String cargoPersonaContacto;
	private String cargoRepLegal;
	private String celular;
	private String direccion;
	private String email;
	private String emailRepLegal;
	private String nit;
	private String nombre;
	private String nombreRepLegal;
	private String numeroIdRepLegal;
	private String personaContacto;
	private String telefono;
	private Ciudad ciudade;
	private Identificacion identificacione1;
	private Identificacion identificacione2;
	private Operador operadore;
	private List<Parqueadero> parqueaderos;

	public Empresa() {
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getCargoRepLegal() {
		return this.cargoRepLegal;
	}

	public void setCargoRepLegal(String cargoRepLegal) {
		this.cargoRepLegal = cargoRepLegal;
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

	public String getEmailRepLegal() {
		return this.emailRepLegal;
	}

	public void setEmailRepLegal(String emailRepLegal) {
		this.emailRepLegal = emailRepLegal;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreRepLegal() {
		return this.nombreRepLegal;
	}

	public void setNombreRepLegal(String nombreRepLegal) {
		this.nombreRepLegal = nombreRepLegal;
	}

	public String getNumeroIdRepLegal() {
		return this.numeroIdRepLegal;
	}

	public void setNumeroIdRepLegal(String numeroIdRepLegal) {
		this.numeroIdRepLegal = numeroIdRepLegal;
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

	public Identificacion getIdentificacione1() {
		return this.identificacione1;
	}

	public void setIdentificacione1(Identificacion identificacione1) {
		this.identificacione1 = identificacione1;
	}

	public Identificacion getIdentificacione2() {
		return this.identificacione2;
	}

	public void setIdentificacione2(Identificacion identificacione2) {
		this.identificacione2 = identificacione2;
	}

	public Operador getOperadore() {
		return this.operadore;
	}

	public void setOperadore(Operador operadore) {
		this.operadore = operadore;
	}

	public List<Parqueadero> getParqueaderos() {
		return this.parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}

	public Parqueadero addParqueadero(Parqueadero parqueadero) {
		getParqueaderos().add(parqueadero);
		parqueadero.setEmpresa(this);

		return parqueadero;
	}

	public Parqueadero removeParqueadero(Parqueadero parqueadero) {
		getParqueaderos().remove(parqueadero);
		parqueadero.setEmpresa(null);

		return parqueadero;
	}

}