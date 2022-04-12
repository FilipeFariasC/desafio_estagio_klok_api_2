package tech.klok.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.klok.challenge.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long> {
	
	@Query("SELECT c FROM Charge c WHERE c.adhesionId = :id")
	List<Charge> findByAdhesionId(@Param("id") Long id);

}
