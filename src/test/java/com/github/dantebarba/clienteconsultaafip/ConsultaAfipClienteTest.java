package com.github.dantebarba.clienteconsultaafip;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.dantebarba.clienteconsultaafip.cliente.ConsultaAfipClienteFactory;
import com.github.dantebarba.clienteconsultaafip.cliente.ServicioAfipException;
import com.github.dantebarba.clienteconsultaafip.exceptions.ConexionException;
import com.github.dantebarba.clienteconsultaafip.exceptions.InstanciaInexistenteException;
import com.github.dantebarba.clienteconsultaafip.model.TipoPersona;
import com.github.dantebarba.clienteconsultaafip.model.responses.ConsultaPersonaAfipResponse;
import com.github.dantebarba.clienteconsultaafip.model.responses.PingResponse;

public class ConsultaAfipClienteTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testPing() {
		PingResponse response = null;
		try {
			response = ConsultaAfipClienteFactory.getInstance().ping();
		} catch (ConexionException e) {
			fail();
		}
		System.out.println(response.getStatusCode()+"");
	}

	@Test
	public void testConsultaCuit() {
		try {
			ConsultaPersonaAfipResponse response = ConsultaAfipClienteFactory
					.getInstance().consultarPorCuit("30646328450");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"30548083156");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"30500008454");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"30711415382");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"20280922928");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"30648839088");
			ConsultaAfipClienteFactory.getInstance().consultarPorCuit(
					"33693450239");
		} catch (ServicioAfipException e) {
			fail();
		}
	}

	@Test
	public void testConsultaTipoPersona() {
		TipoPersona tipoPersonaJuridica = null;
		TipoPersona tipoPersonaFisica = null;
		try {
			tipoPersonaJuridica = ConsultaAfipClienteFactory.getInstance()
					.consultarTipoPersona("30646328450");
			tipoPersonaFisica = ConsultaAfipClienteFactory.getInstance()
					.consultarTipoPersona("27183636427");
		} catch (ServicioAfipException e) {
			fail();
		}
		System.out.println(tipoPersonaJuridica.toString());
		System.out.println(tipoPersonaFisica.toString());
	}

	@Test(expected = ServicioAfipException.class)
	public void testErrorAfip() throws ServicioAfipException {
		TipoPersona tipoPersona = null;
		tipoPersona = ConsultaAfipClienteFactory.getInstance()
				.consultarTipoPersona("2323");
	}

	@After
	public void tearDown() {
		try {
			ConsultaAfipClienteFactory.destroy();
		} catch (InstanciaInexistenteException e) {

		}
	}

}
