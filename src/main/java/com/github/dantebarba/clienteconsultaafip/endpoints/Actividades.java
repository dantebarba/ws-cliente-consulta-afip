package com.github.dantebarba.clienteconsultaafip.endpoints;

public class Actividades implements HasEndpoint {

	@Override
	public String getEndpoint() {
		return new Parametros().getEndpoint() + "/actividades";
	}

}
