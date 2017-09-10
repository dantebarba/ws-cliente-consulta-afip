package com.github.dantebarba.clienteconsultaafip.endpoints;

public class ConsultaPersonaAfip implements HasEndpoint {

	private String cuit = "";

	public ConsultaPersonaAfip(String cuit) {
		this.cuit  = cuit;
	}
	
	@Override
	public String getEndpoint() {
		return "/sr-padron/v2/persona/"+cuit;
	}

}
