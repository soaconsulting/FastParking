/**
 * 
 */
package com.soaconsultingonline.fastparking.database.vo;

import java.io.Serializable;

/**
 * @author Jimmy Vélez Muñoz
 *
 */
public class FPResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3498058977425519848L;
	
	private String message;
	private int statusCode;
	private String severity;

	/**
	 * Default constructor
	 */
	public FPResponse() {
	}
	
	/**
	 * @param message
	 * @param statusCode
	 * @param severity
	 */
	public FPResponse(String message, int statusCode, String severity) {
		this.message = message;
		this.statusCode = statusCode;
		this.severity = severity;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
