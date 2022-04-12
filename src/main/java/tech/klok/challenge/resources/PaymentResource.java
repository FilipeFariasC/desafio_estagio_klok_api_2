package tech.klok.challenge.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.challenge.dto.PaymentDto;
import tech.klok.challenge.dto.post.PaymentPostDto;
import tech.klok.challenge.exception.ChargeNotFoundException;
import tech.klok.challenge.exception.PaymentNotFoundException;
import tech.klok.challenge.model.Payment;
import tech.klok.challenge.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody PaymentPostDto paymentPostDto){
		try {
			Payment payment = paymentService.save(paymentPostDto);
			
			PaymentDto dto = fromPaymentToDto(payment);
			
			return ResponseEntity.ok(dto);
		} catch (ChargeNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<PaymentDto> dtos = paymentService.getAll()
			.stream()
			.map(this::fromPaymentToDto)
			.toList();
		
		return ResponseEntity.ok(dtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
			Payment payment = paymentService.findById(id);
			
			PaymentDto dto = fromPaymentToDto(payment);
			
			return ResponseEntity.ok(dto);
		} catch (PaymentNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		
		try {
			paymentService.delete(id);
			
			return ResponseEntity.ok("Pagamento deletado com sucesso!");
		} catch (PaymentNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
		
		
	}
	private PaymentDto fromPaymentToDto(Payment payment) {
		PaymentDto dto = new PaymentDto();
		
		dto.setId(payment.getId());
		dto.setPayday(payment.getPayday());
		
		return dto;
	}
}
