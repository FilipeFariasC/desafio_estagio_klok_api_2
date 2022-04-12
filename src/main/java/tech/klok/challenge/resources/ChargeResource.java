package tech.klok.challenge.resources;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.klok.challenge.configuration.RabbitMQConfiguration;
import tech.klok.challenge.dto.ChargeDto;
import tech.klok.challenge.dto.post.ChargePostDto;
import tech.klok.challenge.exception.AdhesionNotFoundException;
import tech.klok.challenge.model.Charge;
import tech.klok.challenge.service.ChargeService;

@RestController
@RequestMapping("/charges")
public class ChargeResource {
	@Autowired
	private ChargeService chargeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RabbitListener(queues = {RabbitMQConfiguration.CHARGE_QUEUE})
	public Charge save(@Valid ChargePostDto chargePostDto) {
		Charge charge = chargeService.save(chargePostDto);
		
		return charge;
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<ChargeDto> chargesDto = chargeService.getAll()
				.stream()
				.map(this::mapToDto)
				.toList();
		
		return ResponseEntity.ok(chargesDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByAdhesionId(@PathVariable("id") Long id){
		try {
			List<ChargeDto> chargesDto = chargeService.findByAdhesionId(id)
					.stream()
					.map(this::mapToDto)
					.toList();
			
			return ResponseEntity.ok(chargesDto);
		} catch (AdhesionNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	private ChargeDto mapToDto(Charge charge) {
		return modelMapper.map(charge, ChargeDto.class);
	}
}
