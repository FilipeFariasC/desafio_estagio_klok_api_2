package tech.klok.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.klok.challenge.dto.post.ChargePostDto;
import tech.klok.challenge.exception.AdhesionNotFoundException;
import tech.klok.challenge.model.Charge;
import tech.klok.challenge.repository.ChargeRepository;

@Service
public class ChargeService {
	
	@Autowired
	public ChargeRepository chargeRepo;
	
	public Charge save(ChargePostDto chargePostDto) {
		Charge charge = mapPostDtoToCharge(chargePostDto);
				
		return chargeRepo.save(charge);
	}
	
	public List<Charge> getAll() {
		List<Charge> charges = chargeRepo.findAll();
		
		return charges;
	}
	
	public List<Charge> findByAdhesionId(Long id) throws AdhesionNotFoundException {
		List<Charge> charges = chargeRepo.findByAdhesionId(id);
		
		if(charges.isEmpty())
			throw new AdhesionNotFoundException(id);
		
		return charges;
	}
	
	private Charge mapPostDtoToCharge(ChargePostDto dto) {
		Charge charge = new Charge();
		
		charge.setChargingDate(dto.getChargingDate());
		charge.setAmount(dto.getAmount());
		charge.setAdhesionId(dto.getAdhesionId());
		charge.setStatus(dto.getStatus());
		
		return charge;
	}
}
