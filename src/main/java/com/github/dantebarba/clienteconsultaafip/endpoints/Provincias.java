package com.github.dantebarba.clienteconsultaafip.endpoints;

public class Provincias implements HasEndpoint {

	@Override
	public String getEndpoint() {
		return new Parametros().getEndpoint() + "/provincias";
	}

}
