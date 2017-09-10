package com.github.dantebarba.clienteconsultaafip.cliente;

import com.github.dantebarba.clienteconsultaafip.model.responses.ErrorResponse;

public class ServicioAfipException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicioAfipException(ErrorResponse error) {
		super(error.getMensaje());
	}

}
