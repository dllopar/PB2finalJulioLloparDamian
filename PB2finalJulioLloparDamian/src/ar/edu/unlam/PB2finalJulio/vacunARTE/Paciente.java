package ar.edu.unlam.PB2finalJulio.vacunARTE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Paciente implements Comparable<Paciente>{

	private String nombre;
	private Integer dni;
	private Set<Vacuna> vacunas;
	private List<String>enfermedades;

	public Paciente(String nombre, Integer dni) {

		this.nombre = nombre;
		this.dni = dni;
		vacunas= new HashSet<>();
		enfermedades= new ArrayList<>();

	}
	
	public Boolean vacunadoParaCovid1(Paciente paciente) {
		Boolean vacunado = false;
		Vacuna covidUno = new Covid19Primer("covidUno");
		
		for (Vacuna vacuna : vacunas) {
			if(vacuna.getNombre().equalsIgnoreCase(covidUno.getNombre())){
				vacunado = true;
			}
		}
		return vacunado;
	}
	
	public Boolean vacunadoParaCovid2(Paciente paciente) {
		Boolean vacunado = false;
		Vacuna covidDos = new Covid19Segunda("covidDos");
		
		for (Vacuna vacuna : vacunas) {
			if(vacuna.getNombre().equalsIgnoreCase(covidDos.getNombre())){
				vacunado = true;
			}
		}
		return vacunado;
	}
	
	public Integer contarvacunasDistintas(Paciente paciente) {
		Integer contador = 0;
		Integer vacunasAplicadas= this.cantidadDeVacunasAplicadas();
		
		if(this.vacunadoParaCovid1(paciente) && this.vacunadoParaCovid2(paciente)) {
			contador=vacunasAplicadas-1;
		}
		return contador;
		
		
	}
	
	
	public Boolean ingresarVacunas(Vacuna vacuna) {
		
		return vacunas.add(vacuna);
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

	public List<String> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<String> enfermedades) {
		this.enfermedades = enfermedades;
	}
	
	public Boolean ingresarAlListadoDeEnfermedades(String enfermedad) {
		
		return enfermedades.add(enfermedad);
	}
	
	

}
