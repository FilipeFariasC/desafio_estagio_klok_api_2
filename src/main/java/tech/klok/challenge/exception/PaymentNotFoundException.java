package tech.klok.challenge.exception;

public class PaymentNotFoundException extends Exception {
	public PaymentNotFoundException(Long id) {
		super(String.format("O pagamento com o identificador %d não foi encontrado.", id));
	}
}
