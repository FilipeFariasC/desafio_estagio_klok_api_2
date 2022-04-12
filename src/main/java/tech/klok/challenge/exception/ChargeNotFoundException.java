package tech.klok.challenge.exception;

public class ChargeNotFoundException extends Exception{
	public ChargeNotFoundException(Long id) {
		super(String.format("A cobrança com o identificador %d não foi encontrada",id));
	}
}
