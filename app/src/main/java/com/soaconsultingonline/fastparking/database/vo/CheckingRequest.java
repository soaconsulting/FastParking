/**
 * 
 */
package com.soaconsultingonline.fastparking.database.vo;

import java.io.Serializable;

/**
 * @author Jimmy Vélez Muñoz
 *
 */
public class CheckingRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4209168505029310007L;
	
	/**
	 * Default constructor 
	 */
	public CheckingRequest() {
	}
	
	private ServiciosParqueaderoVO servicioParqueadero;

	/**
	 * @return the servicioParqueadero
	 */
	public ServiciosParqueaderoVO getServicioParqueadero() {
		return servicioParqueadero;
	}
	/**
	 * @param servicioParqueadero the servicioParqueadero to set
	 */
	public void setServicioParqueadero(ServiciosParqueaderoVO servicioParqueadero) {
		this.servicioParqueadero = servicioParqueadero;
	}
	

}
