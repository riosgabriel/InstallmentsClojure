(ns bivatest.core.calculate-test
  (:require [clojure.test :refer :all]
            [bivatest.core.calculation :refer :all]))

(deftest calc-price
  (testing "calculate price"
    (is (= 355.94375681841166 (calculatePrice 2500.0 0.07 10))))

  (testing "calculate with zero number_of_installments")
    (is (= 0 (calculatePrice 2500.0 4 0)))

  (testing "calculate with zero monthly_interest_rate")
    (is (= 0 (calculatePrice 2500.0 0 10)))
  )