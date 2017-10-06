package com.github.dantebarba.clienteconsultaafip.cliente;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.github.dantebarba.clienteconsultaafip.endpoints.ConsultaPersonaAfip;
import com.github.dantebarba.clienteconsultaafip.endpoints.HasEndpoint;
import com.github.dantebarba.clienteconsultaafip.endpoints.Ping;
import com.github.dantebarba.clienteconsultaafip.endpoints.Provincias;
import com.github.dantebarba.clienteconsultaafip.exceptions.ConexionException;
import com.github.dantebarba.clienteconsultaafip.model.HasError;
import com.github.dantebarba.clienteconsultaafip.model.TipoPersona;
import com.github.dantebarba.clienteconsultaafip.model.responses.ConsultaPersonaAfipResponse;
import com.github.dantebarba.clienteconsultaafip.model.responses.ConsultaProvinciasResponse;
import com.github.dantebarba.clienteconsultaafip.model.responses.PingResponse;

public class ConsultaAfipCliente implements HasEndpoint {

	private static String REST_URI = "";

	Client client = ClientBuilder.newClient(new ClientConfig().register(
			LoggingFilter.class).register(JacksonJsonProvider.class));

	protected ConsultaAfipCliente(String url) throws ConexionException {
		if (url == null || url.isEmpty()) {
			throw new IllegalArgumentException("La URL ingresada no es válida.");
		}
		REST_URI = url;
		this.ping();
	}

	private WebTarget getConnection() {
		return client.target(getEndpoint());
	}

	/**
	 * Realiza PING a la url con la que se construye el cliente.
	 * @return {@link PingResponse}.
	 * @throws ConexionException cuando no fue posible recibir una respuesta
	 * http 200.
	 */
	public PingResponse ping() throws ConexionException {
		try {
			Response serverResponse = this.getConnection()
					.path(new Ping().getEndpoint())
					.request(MediaType.APPLICATION_JSON).get();
			PingResponse pingResponse = new PingResponse(
					serverResponse.getStatus());
			if (!pingResponse.ok()) {
				throw new ConexionException(
						"Ha ocurrido un error al intentar conectarse al webservice url: "
								+ REST_URI
								+ ". El servicio ha respondido con código "
								+ pingResponse.getStatusCode());
			}
			return pingResponse;
		} catch (Exception e) {
			throw new ConexionException(
					"Ha ocurrido un error al intentar conectarse al webservice url: "
							+ REST_URI);
		}
	}

	private <T> T processResponse(Response response, Class<T> clazz) {
		if (response.getStatus() != 200) {
			throw new WebApplicationException();
		}
		return response.readEntity(clazz);
	}


	/**
	 * Consulta la persona dado un CUIT determinado. 
	 * @param cuit determinado
	 * @return {@link ConsultaPersonaAfipResponse} con los respectivos datos de la persona
	 * cargados
	 * @throws ServicioAfipException en caso de respuesta no satisfactoria por parte de AFIP.
	 */
	public ConsultaPersonaAfipResponse consultarPorCuit(String cuit)
			throws ServicioAfipException {
		ConsultaPersonaAfipResponse response = processResponse(
				this.getConnection()
						.path(new ConsultaPersonaAfip(cuit).getEndpoint())
						.request().get(), ConsultaPersonaAfipResponse.class);
		this.checkErrors(response);
		return response;
	}

	/**
	 * Consulta el TipoPersona dado un CUIT.
	 * @param cuit
	 * @return {@link TipoPersona}
	 * @throws ServicioAfipException en caso de respuesta no satisfactoria.
	 */
	public TipoPersona consultarTipoPersona(String cuit)
			throws ServicioAfipException {
		if (cuit == null || cuit.isEmpty()) {
			throw new IllegalArgumentException("El cuit ingresado no es válido");
		}
		ConsultaPersonaAfipResponse response = this.consultarPorCuit(cuit);
		this.checkErrors(response);
		return response.getData().getTipoPersona();
	}
	
	public ConsultaProvinciasResponse provincias() throws ServicioAfipException {
		ConsultaProvinciasResponse response = processResponse(this.getConnection().path(new Provincias().getEndpoint()).request().get(), ConsultaProvinciasResponse.class);
		this.checkErrors(response);
		return response;
	}

	private void checkErrors(HasError response) throws ServicioAfipException {
		if (response.hasErrors()) {
			throw new ServicioAfipException(response.getError());
		}
	}

	/**
	 * Obtiene la URL instanciada.
	 */
	@Override
	public String getEndpoint() {
		return REST_URI;
	}

}
