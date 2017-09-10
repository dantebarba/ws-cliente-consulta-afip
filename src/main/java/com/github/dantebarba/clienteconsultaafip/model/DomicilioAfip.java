package com.github.dantebarba.clienteconsultaafip.model;

import java.io.Serializable;

/**
 * Domicilio recuperado de AFIP.
 * @author dbarba
 * 
 */
public class DomicilioAfip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String direccion;

	private String localidad;

	private String codPostal;

	private String idProvincia;

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
