package com.github.dantebarba.clienteconsultaafip.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Persona recuperada de AFIP.
 * @author dbarba
 * 
 */
public class PersonaAfip implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idPersona;

	private TipoPersona tipoPersona;

	private String tipoClave;

	private String estadoClave;

	private String tipoDocumento;

	private String numeroDocumento;

	private String nombre;

	private DomicilioAfip domicilioFiscal;

	private Long idDependencia;

	private Integer mesCierre;

	private Date fechaInscripcion;

	private Date fechaContratoSocial;

	private List<Integer> actividades = new ArrayList<Integer>();
	
	private List<Integer> impuestos = new ArrayList<Integer>();
	
	private List<Integer> caracterizaciones = new ArrayList<Integer>();
	
	public List<Integer> getActividades() {
		return actividades;
	}

	public void setActividades(List<Integer> actividades) {
		this.actividades = actividades;
	}

	public Date getFechaContratoSocial() {
		return fechaContratoSocial;
	}

	public void setFechaContratoSocial(Date fechaContratoSocial) {
		this.fechaContratoSocial = fechaContratoSocial;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Integer getMesCierre() {
		return mesCierre;
	}

	public void setMesCierre(Integer mesCierre) {
		this.mesCierre = mesCierre;
	}

	public Long getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public DomicilioAfip getDomicilioFiscal() {
		return domicilioFiscal;
	}

	public void setDomicilioFiscal(DomicilioAfip domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getEstadoClave() {
		return estadoClave;
	}

	public void setEstadoClave(String estadoClave) {
		this.estadoClave = estadoClave;
	}

	public String getTipoClave() {
		return tipoClave;
	}

	public void setTipoClave(String tipoClave) {
		this.tipoClave = tipoClave;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public List<Integer> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<Integer> impuestos) {
		this.impuestos = impuestos;
	}

	public List<Integer> getCaracterizaciones() {
		return caracterizaciones;
	}

	public void setCaracterizaciones(List<Integer> caracterizaciones) {
		this.caracterizaciones = caracterizaciones;
	}

}
