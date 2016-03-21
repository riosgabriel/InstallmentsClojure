(ns bivatest.entities-test
  (:use clojure.test
        bivatest.entities)
  (:require [bivatest.entities :as installments]
            [environ.core :refer [env]]))

; Run each test in an isolated db transaction and rollback
; afterwards
;(use-fixtures :each with-rollback)

(deftest create-read-users
  (testing "Add installment"
    (let [present 1000M
          rate 0.03
          n-installment 4
          added-installment (installments/add present rate n-installment)]
      (is (= (added-installment :present_value) present))))
  )