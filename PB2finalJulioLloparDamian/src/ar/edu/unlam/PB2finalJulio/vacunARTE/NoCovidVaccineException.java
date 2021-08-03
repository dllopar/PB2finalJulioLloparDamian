package ar.edu.unlam.PB2finalJulio.vacunARTE;

public class NoCovidVaccineException extends Exception {
	
	public NoCovidVaccineException() {
		super("El paciente no tiene aplicada la primer dosis");
	}

}
