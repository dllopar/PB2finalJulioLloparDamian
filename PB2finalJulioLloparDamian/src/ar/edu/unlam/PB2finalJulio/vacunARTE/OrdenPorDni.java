package ar.edu.unlam.PB2finalJulio.vacunARTE;

import java.util.Comparator;

public class OrdenPorDni implements Comparator<Paciente> {

	@Override
	public int compare(Paciente o1, Paciente o2) {
		
		return o1.getDni().compareTo(o2.getDni());
	}

}
