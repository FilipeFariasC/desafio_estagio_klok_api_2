package tech.klok.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.klok.challenge.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
