(ns bivatest.entities
  (:use korma.core  bivatest.db))

(declare installment)

(defentity installment
           (pk :id)
           (table :installments)
           (entity-fields :present_value :number_of_installments :monthly_interest_rate :installment_value))

;(select installment)

(defn select-all [] (select installment))