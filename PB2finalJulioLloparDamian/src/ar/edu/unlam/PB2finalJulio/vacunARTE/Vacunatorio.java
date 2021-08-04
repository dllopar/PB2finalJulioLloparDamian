package ar.edu.unlam.PB2finalJulio.vacunARTE;

import java.util.Set;
import java.util.TreeSet;

public class Vacunatorio {

	private String nombre;
	private Set<Paciente> vacunados;

	public Vacunatorio(String nombre) {
		this.nombre = nombre;
		vacunados = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Paciente> getVacunados() {
		return vacunados;
	}

	public void setVacunados(Set<Paciente> vacunados) {
		this.vacunados = vacunados;
	}

	public Boolean pacienteVacunasCovidCompletas(Paciente paciente) {
		Boolean vacunado = false;
		if (paciente.vacunadoParaCovid1(paciente) && paciente.vacunadoParaCovid2(paciente)) {
			vacunado = true;

		}
		return vacunado;
	}

	public Boolean pacienteParaSegundaDosisDeCovid(Paciente paciente) throws NoCovidVaccineException {

		Boolean apto = false;

		if (paciente.vacunadoParaCovid1(paciente)) {
			apto = true;
		} else {
			throw new NoCovidVaccineException();

		}
		return apto;
	}

	public Boolean verificarSiPuedeRecibirVacunaRubeola(Paciente paciente) {

		Boolean noapto = false;
		if (paciente.getEnfermedades().equals("rubeola")) {
			noapto = true;
		}
		return noapto;

	}

	public Boolean verificarSiPuedeRecibirVacunaHepatitis(Paciente paciente) {

		Boolean noapto = false;
		if (paciente.getEnfermedades().equals("hepatitis")) {
			noapto = true;
		}
		return noapto;

	}
	
	public Boolean comprobarSiTieneMasDeDosVacunasDistintas(Paciente paciente) throws NoMoreVaccineException {
		
		Boolean tieneMas=true;
		Integer esperado = paciente.contarvacunasDistintas(paciente);
		if(!(esperado>2)) {
			tieneMas=false;
		}else {
			throw new NoMoreVaccineException();

		}
		return tieneMas;
		
	}

}
