package ar.edu.unlam.PB2finalJulio.vacunARTETest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.PB2finalJulio.vacunARTE.Covid19Primer;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Covid19Segunda;
import ar.edu.unlam.PB2finalJulio.vacunARTE.HepatitisA;
import ar.edu.unlam.PB2finalJulio.vacunARTE.NoCovidVaccineException;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Paciente;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Rubeola;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Vacuna;
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
	
	@Test
	public void testQuecompruebaQueElPAcientePoseeLasDosDosisDelCovid() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		
		marcelo.ingresarVacunas(coviduno);
		marcelo.ingresarVacunas(coviddos);
		

		
		assertTrue(vacunarte.pacienteVacunasCovidCompletas(marcelo));
	}
	
	@Test(expected = NoCovidVaccineException.class)
	public void testQuecompruebaQueElPAcienteNoPoseelaPrimerDosisYNoSePuedeAplicarLaSegunda() throws NoCovidVaccineException {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		
		
		assertTrue(vacunarte.pacienteParaSegundaDosisDeCovid(marcelo));
	}
	
	@Test
	public void testQuecompruebaQueElPAcienteTuboRubeolaAnteriormenteYNoSePuedeVacunar() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		Rubeola rubeola = new Rubeola("rubeola");
		String rubeolaEnfermedad = new String();
		
		marcelo.ingresarAlListadoDeEnfermedades(rubeolaEnfermedad);
		
		

		
		assertFalse(vacunarte.verificarSiPuedeRecibirVacunaRubeola(marcelo));
	}
	
	@Test
	public void testQuecompruebaQueElPAcientePoseeMasDeDosVacunasDistintas() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		Rubeola rubeola = new Rubeola("Rubeola");
		HepatitisA hepatitisA = new HepatitisA("hepatitisuno");
		
		marcelo.ingresarVacunas(coviduno);
		marcelo.ingresarVacunas(coviddos);
		marcelo.ingresarVacunas(hepatitisA);
		marcelo.ingresarVacunas(rubeola);
		
		assertTrue(vacunarte.comprobarSiTieneMasDeDosVacunasDistintas(marcelo));
	}
	

}
