package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the puntos_comprados database table.
 * 
 */
public class PuntosComprados implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal cantidadPuntos;
	private Date vencimiento;
	private CompraPuntos compraPuntos;
	private Usuario usuario;
	private BigDecimal factorCompra;

	public PuntosComprados() {
	}

	public BigDecimal getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void setCantidadPuntos(BigDecimal cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public CompraPuntos getCompraPuntos() {
		return compraPuntos;
	}

	public void setCompraPuntos(CompraPuntos compraPuntos) {
		this.compraPuntos = compraPuntos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getFactorCompra() {
		return factorCompra;
	}

	public void setFactorCompra(BigDecimal factorCompra) {
		this.factorCompra = factorCompra;
	}
}