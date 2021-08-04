package ar.edu.unlam.PB2finalJulio.vacunARTETest;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.PB2finalJulio.vacunARTE.Covid19Primer;
import ar.edu.unlam.PB2finalJulio.vacunARTE.Covid19Segunda;
import ar.edu.unlam.PB2finalJulio.vacunARTE.HepatitisA;
import ar.edu.unlam.PB2finalJulio.vacunARTE.NoCovidVaccineException;
import ar.edu.unlam.PB2finalJulio.vacunARTE.NoMoreVaccineException;
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
	public void testQuecompruebaQueElPAcienteNoPoseeMasDeDOsVacunas() throws NoMoreVaccineException {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222555);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		Rubeola rubeola = new Rubeola("Rubeola");
		HepatitisA hepatitisA = new HepatitisA("hepatitisuno");
		
		marcelo.ingresarVacunas(coviduno);
		marcelo.ingresarVacunas(coviddos);
		marcelo.ingresarVacunas(hepatitisA);
		//marcelo.ingresarVacunas(rubeola);
		
		
		assertFalse(vacunarte.comprobarSiTieneMasDeDosVacunasDistintas(marcelo));
	}
	
	@Test(expected = NoMoreVaccineException.class)
	public void testQuecompruebaQueElPAcientePoseeMasDeDOsVacunas() throws NoMoreVaccineException {
		
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
		
		
		assertFalse(vacunarte.comprobarSiTieneMasDeDosVacunasDistintas(marcelo));
	}
	

	@Test
	public void testQuecompruebaQueLosPacientesEstenOrdenadosPorNombre() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222);
		Paciente carla = new Paciente("carla", 333);
		Paciente fabiana = new Paciente("fabiana", 444);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		Rubeola rubeola = new Rubeola("Rubeola");
		HepatitisA hepatitisA = new HepatitisA("hepatitisuno");
		
		marcelo.ingresarVacunas(coviduno);
		fabiana.ingresarVacunas(hepatitisA);
		carla.ingresarVacunas(rubeola);
		
		vacunarte.ingresarPacientesVacunados(carla);
		vacunarte.ingresarPacientesVacunados(fabiana);
		vacunarte.ingresarPacientesVacunados(marcelo);
		
		
		assertEquals(vacunarte.getVacunados().first(), carla);
		assertEquals(vacunarte.getVacunados().last(), marcelo);
		
	}
	
	@Test
	public void testQuecompruebaQueLosPacientesEstenOrdenadosPorDni() {
		
		Vacunatorio vacunarte = new Vacunatorio("VacunARTE");
		Paciente marcelo = new Paciente("Marcelo", 222);
		Paciente carla = new Paciente("carla", 333);
		Paciente fabiana = new Paciente("fabiana", 444);
		Covid19Primer coviduno = new Covid19Primer("covidUno");
		Covid19Segunda coviddos = new Covid19Segunda("covidDos");
		Rubeola rubeola = new Rubeola("Rubeola");
		HepatitisA hepatitisA = new HepatitisA("hepatitisuno");
		
		marcelo.ingresarVacunas(coviduno);
		fabiana.ingresarVacunas(hepatitisA);
		carla.ingresarVacunas(rubeola);
		
		vacunarte.ingresarPacientesVacunados(carla);
		vacunarte.ingresarPacientesVacunados(fabiana);
		vacunarte.ingresarPacientesVacunados(marcelo);
		
		vacunarte.ordenarPacientesPorNumeroDeDni();
		
		assertEquals(vacunarte.getVacunados().first(), marcelo);
		assertEquals(vacunarte.getVacunados().last(), fabiana);
		
	}
	

}
