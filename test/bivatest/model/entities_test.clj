(ns bivatest.model.entities-test
  (:use clojure.test
   :use bivatest.model.entities)
  (:require [bivatest.model.entities :as installments]
            [environ.core :refer [env]]))

;(use-fixtures :each with-rollback)

(deftest create-read-users
   (testing "Add installment"
      (let [present 1000M
            rate 0.03
            n-installment 4
            added-installment (installments/add present rate n-installment)]
        (is (= (added-installment :present_value) present))))

   (testing "Get installment"
       (let [present 1000M
             rate 0.03
             n-installment 4
             uuid (get-in (select-keys (installments/add present rate n-installment) [:id]) [:id])
             installment (installments/select-by-id (str uuid))]
         (is (= (installment :id) uuid))))
)
