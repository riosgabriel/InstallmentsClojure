-- name: all-contacts
-- Selects all contacts
SELECT id,
       present_value,
       number_of_installments,
       monthly_interest_rate,
       installment_value
FROM installments;

-- name: insert-contact<!
-- Queries a single contact
INSERT INTO installments (id, present_value, number_of_installments, monthly_interest_rate, installment_value)
    VALUES (uuid_generate_v4(), :presentValue, :installments, :rate, :value);

DELETE FROM installments WHERE id = :id

-- name: drop-contacts-table!
-- drop the contacts table
DROP TABLE installments;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- name: create-contacts-table-if-not-exists!
-- create the contacts table if it does not exist
CREATE TABLE IF NOT EXISTS INSTALLMENTS (
   id uuid PRIMARY KEY,
   present_value NUMERIC NOT NULL,
   number_of_installments INTEGER NOT NULL,
   monthly_interest_rate NUMERIC NOT NULL,
   installment_value NUMERIC NOT NULL);