
CREATE TABLE IF NOT EXISTS t_charge (
	charge_id BIGSERIAL NOT NULL,
	payday DATE NOT NULL,
	status VARCHAR NOT NULL,
	amount NUMERIC(11,2) NOT NULL,
	payment_id_fk BIGINT,
	adhesion_id_fk BIGINT,
	
	CONSTRAINT charge_pk PRIMARY KEY (charge_id),
	CONSTRAINT payment_id_fk_charge FOREIGN KEY (payment_id_fk) REFERENCES t_payment (payment_id)
);