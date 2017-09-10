package com.github.dantebarba.clienteconsultaafip.model.responses;

/**
 * Respuesta de ping. Contiene el status code.
 * @author dbarba
 *
 */
public class PingResponse {

	private int statusCode = -1;

	public PingResponse(int status) {
		statusCode = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int code) {
		this.statusCode = code;
	}

	public boolean ok() {
		return this.statusCode == 200;
	}

}
