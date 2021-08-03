package ar.edu.unlam.PB2finalJulio.vacunARTE;

import java.util.HashSet;
import java.util.Set;

public class Paciente implements Comparable<Paciente>{

	private String nombre;
	private Integer dni;
	private Set<Vacuna> vacunas;

	public Paciente(String nombre, Integer dni) {

		this.nombre = nombre;
		this.dni = dni;
		vacunas= new HashSet<>();

	}
	
	public Integer cantidadDeVacunasAplicadas() {
		
		return vacunas.size();
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getDni() {
		return dni;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public Set<Vacuna> getVacunas() {
		return vacunas;
	}



	public void setVacunas(Set<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}



	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		return this.nombre.compareToIgnoreCase(o.getNombre());
	}

}
