package tech.klok.challenge.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import tech.klok.challenge.model.categories.ChargeStatus;

@Entity
@Table(name="t_charge")
public class Charge implements Serializable{

	private static final long serialVersionUID = -8843957538784161722L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="charge_id")
	private Long id;
	
	@NotNull
	@Column(name="adhesion_id_fk")
	private Long adhesionId;
	
	@Min(value=0)
	@Column(name="amount")
	private Double amount;
	
	@Column(name="charging_date", columnDefinition = "DATE")
	private LocalDate chargingDate;
	
	@NotNull
	private ChargeStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id_fk")
	private Payment payment;


	public LocalDate getChargingDate() {
		return chargingDate;
	}
	public void setChargingDate(LocalDate chargingDate) {
		this.chargingDate = chargingDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public ChargeStatus getStatus() {
		return status;
	}
	public void setStatus(ChargeStatus status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Long getAdhesionId() {
		return adhesionId;
	}
	public void setAdhesionId(Long adhesionId) {
		this.adhesionId = adhesionId;
	}
	
	
	
}
