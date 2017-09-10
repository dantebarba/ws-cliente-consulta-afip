package com.github.dantebarba.clienteconsultaafip.exceptions;

/**
 * Se intenta destruir una instancia que no fue creada.
 * @author dbarba
 *
 */
public class InstanciaInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InstanciaInexistenteException() {
		super("La instancia no fue creada.");
	}

}
