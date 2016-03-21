(ns bivatest.core.calculate-test
  (:require [clojure.test :refer :all]
            [bivatest.core.calculate :refer :all]))

(deftest calc-price
  (is (= 355.94375681841166 (calculatePrice 2500.0 0.07 10))))
