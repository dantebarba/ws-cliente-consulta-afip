package com.github.dantebarba.clienteconsultaafip.model.responses;

import java.io.Serializable;

/**
 * Representa el error emitido por AFIP. Solo se completa si <b>NO</b>
 * {@link ConsultaPersonaAfipResponse#isSuccess()}
 * @author dbarba
 *
 */
public class ErrorResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private String tipoError;
	// {"success":false,"error":{ "tipoError":"client","mensaje":"Id invalido"}}
	public ErrorResponse() {

	}

	public ErrorResponse(String reasonPhrase,
			String localizedMessage) {
		this.mensaje = localizedMessage;
		this.tipoError = reasonPhrase;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String errorMessage) {
		this.mensaje = errorMessage;
	}

	public String getTipoError() {
		return tipoError;
	}

	public void setTipoError(String errorType) {
		this.tipoError = errorType;
	}

}
