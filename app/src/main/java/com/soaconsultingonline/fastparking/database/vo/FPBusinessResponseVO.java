/**
 * 
 */
package com.soaconsultingonline.fastparking.database.vo;

import java.io.Serializable;

/**
 * Encapsula los datos de respuesta de los servicios de negocio
 * 
 * @author Jimmy Vélez Muñoz
 *
 */
public class FPBusinessResponseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8602303842636737097L;
	
	private String statusMsg;
	private String statusCode;
	private String statusSeverity;
	private String reasonCode;
	private String reasonMsg;
	
	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}
	/**
	 * @param statusMsg the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the statusSeverity
	 */
	public String getStatusSeverity() {
		return statusSeverity;
	}
	/**
	 * @param statusSeverity the statusSeverity to set
	 */
	public void setStatusSeverity(String statusSeverity) {
		this.statusSeverity = statusSeverity;
	}
	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}
	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	/**
	 * @return the reasonMsg
	 */
	public String getReasonMsg() {
		return reasonMsg;
	}
	/**
	 * @param reasonMsg the reasonMsg to set
	 */
	public void setReasonMsg(String reasonMsg) {
		this.reasonMsg = reasonMsg;
	}

}
