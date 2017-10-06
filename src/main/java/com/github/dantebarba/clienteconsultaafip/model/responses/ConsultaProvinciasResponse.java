package com.github.dantebarba.clienteconsultaafip.model.responses;

import java.util.ArrayList;
import java.util.List;

import com.github.dantebarba.clienteconsultaafip.model.HasError;
import com.github.dantebarba.clienteconsultaafip.model.Provincia;

public class ConsultaProvinciasResponse implements HasError {

	private boolean success = false;

	private List<Provincia> data = new ArrayList<Provincia>();
	
	private ErrorResponse error = new ErrorResponse();
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Provincia> getData() {
		return data;
	}

	public void setData(List<Provincia> data) {
		this.data = data;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

	@Override
	public boolean hasErrors() {
		return !this.isSuccess();
	}
	
	
}
