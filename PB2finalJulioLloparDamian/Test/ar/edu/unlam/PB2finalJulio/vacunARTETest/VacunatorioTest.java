package ar.edu.unlam.PB2finalJulio.vacunARTETest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.PB2finalJulio.vacunARTE.Paciente;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Vacunatorio;

public class VacunatorioTest {

	@Test
	public void testQuecompruebaQueElPAcienteNoPoseeVacunas() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		
		Integer esperado =0;
		Integer actual = marcelo.cantidadDeVacunasAplicadas();
		
		assertEquals(actual, esperado);
	}

}
