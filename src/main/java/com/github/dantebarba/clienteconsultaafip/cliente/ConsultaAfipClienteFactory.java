package com.github.dantebarba.clienteconsultaafip.cliente;

import javax.xml.ws.WebServiceException;

import org.apache.log4j.Logger;

import com.github.dantebarba.clienteconsultaafip.exceptions.ConexionException;
import com.github.dantebarba.clienteconsultaafip.exceptions.InstanciaCreadaException;
import com.github.dantebarba.clienteconsultaafip.exceptions.InstanciaInexistenteException;

public class ConsultaAfipClienteFactory {

	private static final String SOA_AFIP_URL = "https://soa.afip.gob.ar";
	private static ConsultaAfipCliente instance = null;
	private static Logger logger = Logger
			.getLogger(ConsultaAfipClienteFactory.class.getName());

	/**
	 * Obtiene la instancia creada. <i>Si no existe la instancia, crea
	 * una nueva instancia con la URL por defecto soa.afip.gob.ar</i>
	 * @return La nueva instancia creada {@link ConsultaAfipCliente}
	 */
	public static ConsultaAfipCliente getInstance() {
		// logger.error("La instancia ya fue creada");
		// throw new IllegalStateException(
		// "La instancia no fue creada, por favor cree la instancia del servicio con WsNegocioAduanaSingleton#createSingleton(String locatorUrl)");
		try {
			return newInstance(SOA_AFIP_URL);
		} catch (InstanciaCreadaException e) {
			// IGNORE
		} catch (ConexionException e) {
			logger.error(e.getMessage(), e);
			throw new WebServiceException(e.getMessage());
		}
		return ConsultaAfipClienteFactory.instance;
	}

	/**
	 * Crea una nueva instancia. Verifica que la url ingresada por parametro sea
	 * válida. Si llamamos a {@link ConsultaAfipClienteFactory#newInstance(String)} 
	 * antes de llamar a {@link ConsultaAfipClienteFactory#getInstance()} podemos
	 * ingresar como parametro una locatorUrl propia.
	 * 
	 * @param locatorUrl
	 * @return La nueva instancia creada
	 * @throws InstanciaCreadaException cuando la instancia ya fue creada
	 * @throws ConexionException cuando no es posible conectarse a locatorUrl
	 */
	public static ConsultaAfipCliente newInstance(String locatorUrl)
			throws InstanciaCreadaException, ConexionException {
		if (isCreated()) {
			throw new InstanciaCreadaException();
		}
		ConsultaAfipClienteFactory.instance = new ConsultaAfipCliente(
				locatorUrl);
		return ConsultaAfipClienteFactory.getInstance();
	}

	/**
	 * Destruye la instancia creada. Util para casos de test.
	 * @throws InstanciaInexistenteException
	 */
	public static void destroy() throws InstanciaInexistenteException {
		if (isCreated()) {
			ConsultaAfipClienteFactory.instance = null;
		}
		throw new InstanciaInexistenteException();
	}

	/**
	 * Permite comprobar si la instancia fue creada.
	 * @return true si la instancia fue creada.
	 */
	public static boolean isCreated() {
		return instance != null;
	}

}
