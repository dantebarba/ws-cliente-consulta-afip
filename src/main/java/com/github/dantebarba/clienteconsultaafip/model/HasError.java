package com.github.dantebarba.clienteconsultaafip.model;

import com.github.dantebarba.clienteconsultaafip.model.responses.ErrorResponse;

/**
 * Helper interface.
 * @author dbarba
 *
 */
public interface HasError {

	
	public ErrorResponse getError();

	boolean hasErrors();
	
}
