package ar.edu.unlam.PB2finalJulio.vacunARTE;

import java.util.Set;
import java.util.TreeSet;

public class Vacunatorio {
	
	private String nombre;
	private Set<Paciente>vacunados;

	public Vacunatorio(String nombre) {
		this.nombre=nombre;
		vacunados= new TreeSet<>();
	}
	
	

}
