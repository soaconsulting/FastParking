package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the bajas_usuario database table.
 * 
 */
public class BajasUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idBajaUsuario;
	private String comentarios;
	private Date fechaBaja;
	private MotivosBaja motivosBaja;
	private Usuario usuario;

	public BajasUsuario() {
	}

	public Long getIdBajaUsuario() {
		return this.idBajaUsuario;
	}

	public void setIdBajaUsuario(Long idBajaUsuario) {
		this.idBajaUsuario = idBajaUsuario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public MotivosBaja getMotivosBaja() {
		return this.motivosBaja;
	}

	public void setMotivosBaja(MotivosBaja motivosBaja) {
		this.motivosBaja = motivosBaja;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}