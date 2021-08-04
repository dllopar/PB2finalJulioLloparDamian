package ar.edu.unlam.PB2finalJulio.vacunARTE;

public class NoMoreVaccineException extends Exception {
	
	public NoMoreVaccineException() {
		super("Ya tiene aplicada muchas vacunas");
	}

}
