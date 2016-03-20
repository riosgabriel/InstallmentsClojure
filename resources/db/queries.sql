DROP TABLE installments;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS INSTALLMENTS (
   id uuid PRIMARY KEY,
   present_value NUMERIC NOT NULL,
   number_of_installments INTEGER NOT NULL,
   monthly_interest_rate NUMERIC NOT NULL,
   installment_value NUMERIC NOT NULL);

INSERT INTO installments (id, present_value, number_of_installments, monthly_interest_rate, installment_value)
    VALUES (uuid_generate_v4(), :?, :?, :?, :?);

