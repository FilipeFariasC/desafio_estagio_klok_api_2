package tech.klok.challenge.dto.post;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import tech.klok.challenge.model.categories.ChargeStatus;

public class ChargePostDto {
	
	@NotNull
	private Long adhesionId;
	
	@NotNull
	private Double amount;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate chargingDate;
	
	private ChargeStatus status;
	private Long paymentId;
	public Long getAdhesionId() {
		return adhesionId;
	}
	public void setAdhesionId(Long adhesionId) {
		this.adhesionId = adhesionId;
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
