package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the inventario_puntos database table.
 * 
 */
public class InventarioPuntos implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idInventarioPuntos;
	private BigDecimal entrada;
	private BigDecimal existencias;
	private Date fecha;
	private BigDecimal salida;
	private ConceptosInventario conceptosInventario;
	private PuntosGanados puntosGanado;
	private Usuario usuario;

	public InventarioPuntos() {
	}

	public Long getIdInventarioPuntos() {
		return this.idInventarioPuntos;
	}

	public void setIdInventarioPuntos(Long idInventarioPuntos) {
		this.idInventarioPuntos = idInventarioPuntos;
	}

	public BigDecimal getEntrada() {
		return this.entrada;
	}

	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}

	public BigDecimal getExistencias() {
		return this.existencias;
	}

	public void setExistencias(BigDecimal existencias) {
		this.existencias = existencias;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSalida() {
		return this.salida;
	}

	public void setSalida(BigDecimal salida) {
		this.salida = salida;
	}

	public ConceptosInventario getConceptosInventario() {
		return this.conceptosInventario;
	}

	public void setConceptosInventario(ConceptosInventario conceptosInventario) {
		this.conceptosInventario = conceptosInventario;
	}

	public PuntosGanados getPuntosGanado() {
		return this.puntosGanado;
	}

	public void setPuntosGanado(PuntosGanados puntosGanado) {
		this.puntosGanado = puntosGanado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}