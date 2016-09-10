package com.soaconsultingonline.fastparking.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the puntos_ganados database table.
 * 
 */
public class PuntosGanados implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idPago;
	private BigDecimal puntosGanados;
	private Date vencimiento;
	private List<InventarioPuntos> inventarioPuntos;
	private Pago pago;
	private Usuario usuario;

	public PuntosGanados() {
	}

	public Long getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public BigDecimal getPuntosGanados() {
		return this.puntosGanados;
	}

	public void setPuntosGanados(BigDecimal puntosGanados) {
		this.puntosGanados = puntosGanados;
	}

	public Date getVencimiento() {
		return this.vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public List<InventarioPuntos> getInventarioPuntos() {
		return this.inventarioPuntos;
	}

	public void setInventarioPuntos(List<InventarioPuntos> inventarioPuntos) {
		this.inventarioPuntos = inventarioPuntos;
	}

	public InventarioPuntos addInventarioPunto(InventarioPuntos inventarioPunto) {
		getInventarioPuntos().add(inventarioPunto);
		inventarioPunto.setPuntosGanado(this);

		return inventarioPunto;
	}

	public InventarioPuntos removeInventarioPunto(InventarioPuntos inventarioPunto) {
		getInventarioPuntos().remove(inventarioPunto);
		inventarioPunto.setPuntosGanado(null);

		return inventarioPunto;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}