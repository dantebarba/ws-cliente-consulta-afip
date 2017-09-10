package com.github.dantebarba.clienteconsultaafip.model.responses;

import java.io.Serializable;

import com.github.dantebarba.clienteconsultaafip.model.HasError;
import com.github.dantebarba.clienteconsultaafip.model.PersonaAfip;

/**
 * Respuesta con los datos de la persona de AFIP.
 * En caso de error, se puede conocer su detalle consultando
 * {@link ConsultaPersonaAfipResponse#isSuccess()} y 
 * {@link ConsultaPersonaAfipResponse#getError()}
 * @author dbarba
 *
 */
public class ConsultaPersonaAfipResponse implements Serializable, HasError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private PersonaAfip data = new PersonaAfip();

	private ErrorResponse error = new ErrorResponse();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public PersonaAfip getData() {
		return data;
	}

	public void setData(PersonaAfip data) {
		this.data = data;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse response) {
		this.error = response;
	}

	@Override
	public boolean hasErrors() {
		return !success;
	}


}
