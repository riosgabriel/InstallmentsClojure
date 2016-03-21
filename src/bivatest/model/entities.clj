(ns bivatest.model.entities
  (:use korma.core
   :use bivatest.db.db
   :use bivatest.core.calculation))

(declare installment)

(defentity installment
           (pk :id)
           (table :installments)
           (entity-fields :id :present_value :number_of_installments :monthly_interest_rate :installment_value))

(defn uuid-from-string [data] (java.util.UUID/fromString data))

(defn uuid [] (java.util.UUID/randomUUID))

(defn select-all [] (select installment))

(defn select-by-id [id] (first (select installment
                            (where {:id (uuid-from-string id)}))))

(defn delete-by-id [id] (delete installment
                                (where {:id (uuid-from-string id)})))

(defn add [present rate n-installment] (insert installment
                        (values {:id (uuid)
                                 :present_value present
                                 :number_of_installments n-installment
                                 :monthly_interest_rate rate
                                 :installment_value (calculatePrice present rate n-installment)} )))