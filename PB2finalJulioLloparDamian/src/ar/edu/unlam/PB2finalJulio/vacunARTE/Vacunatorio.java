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

}
