package com.github.dantebarba.clienteconsultaafip.exceptions;

/**
 * La instancia ya fue creada previamente. Se debe utilizar la instancia que ha
 * sido creada. Previene que se creen multiples instancias con diferentes URL.
 * @author dbarba
 *
 */
public class InstanciaCreadaException extends Exception {

	public InstanciaCreadaException() {
		super("El Singleton ya fue creado previamente, use ConsultaAfipClienteFactory#getInstance()");
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
