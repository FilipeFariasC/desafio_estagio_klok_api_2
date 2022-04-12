package tech.klok.challenge.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import tech.klok.challenge.model.Payment;
import tech.klok.challenge.model.categories.ChargeStatus;

public class ChargeDto {
	
	private Long id;
	
	private Double amount;
	
	private LocalDate chargingDate;
	
	private ChargeStatus status;
	
	private Long paymentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getChargingDate() {
		return chargingDate;
	}

	public void setChargingDate(LocalDate chargingDate) {
		this.chargingDate = chargingDate;
	}

	public ChargeStatus getStatus() {
		return status;
	}

	public void setStatus(ChargeStatus status) {
		this.status = status;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
