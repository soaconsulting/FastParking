package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	private String activo;
	private String apellido1;
	private String apellido2;
	private String celular;
	private String email;
	private Date fechaAlta;
	private String nombres;
	private String passwd;
	private List<BajasUsuario> bajasUsuarios;
	private TiposAuth tiposAuth;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<BajasUsuario> getBajasUsuarios() {
		return this.bajasUsuarios;
	}

	public void setBajasUsuarios(List<BajasUsuario> bajasUsuarios) {
		this.bajasUsuarios = bajasUsuarios;
	}

	public BajasUsuario addBajasUsuario(BajasUsuario bajasUsuario) {
		getBajasUsuarios().add(bajasUsuario);
		bajasUsuario.setUsuario(this);

		return bajasUsuario;
	}

	public BajasUsuario removeBajasUsuario(BajasUsuario bajasUsuario) {
		getBajasUsuarios().remove(bajasUsuario);
		bajasUsuario.setUsuario(null);

		return bajasUsuario;
	}

	public TiposAuth getTiposAuth() {
		return this.tiposAuth;
	}

	public void setTiposAuth(TiposAuth tiposAuth) {
		this.tiposAuth = tiposAuth;
	}

}