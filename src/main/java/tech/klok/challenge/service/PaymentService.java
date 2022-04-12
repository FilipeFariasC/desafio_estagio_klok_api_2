package tech.klok.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.klok.challenge.dto.post.PaymentPostDto;
import tech.klok.challenge.exception.ChargeNotFoundException;
import tech.klok.challenge.exception.PaymentNotFoundException;
import tech.klok.challenge.model.Charge;
import tech.klok.challenge.model.Payment;
import tech.klok.challenge.model.categories.ChargeStatus;
import tech.klok.challenge.repository.ChargeRepository;
import tech.klok.challenge.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private ChargeRepository chargeRepo;
	
	public Payment save(PaymentPostDto paymentPostDto) throws ChargeNotFoundException {
		Long chargeId = paymentPostDto.getIdCharge();
		
		Optional<Charge> register = chargeRepo.findById(chargeId);
		
		if(register.isEmpty())
			throw new ChargeNotFoundException(chargeId);
		
		Charge charge = register.get();
		Payment payment = new Payment();
		
		charge.setPayment(payment);
		charge.setStatus(ChargeStatus.PAID);
		chargeRepo.save(charge);
		
		return payment;
	}
	
	public List<Payment> getAll() {
		return paymentRepo.findAll();
	}
	
	public Payment findById(Long id) throws PaymentNotFoundException {
		Optional<Payment> register = paymentRepo.findById(id);
		
		if(register.isEmpty())
			throw new PaymentNotFoundException(id);
		
		
		return register.get();
	}
	
	public void delete(Long id) throws PaymentNotFoundException {
		Payment payment = findById(id);
		
		paymentRepo.delete(payment);
//		paymentRepo.deleteById(id); era assim, mas eu prefiro passar alguma informação pro controller.
	}
	
	private Payment mapToPayment(PaymentPostDto paymentPostDto) {
		Payment payment = new Payment();
		
		payment.setPayday(paymentPostDto.getPayday());
		
		return payment;
	}
}
