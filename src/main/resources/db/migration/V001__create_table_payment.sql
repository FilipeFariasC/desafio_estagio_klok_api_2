
CREATE TABLE IF NOT EXISTS t_payment (
	payment_id BIGSERIAL NOT NULL,
	payday DATE NOT NULL,
	
	CONSTRAINT payment_id_pk PRIMARY KEY (payment_id)
);