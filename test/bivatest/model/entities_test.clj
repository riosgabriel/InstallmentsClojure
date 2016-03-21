(ns bivatest..model.entities-test
  (:use clojure.test
   :use bivatest.model.entities)
  (:require [bivatest.model.entities :as installments]
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

  ;(testing "Get installment"
  ;  (let [user (users/create {:name "Andrew" :email "me@mytest.com"})
  ;        found-user (users/find-by-id (user :id))]
  ;    (is (= "Andrew" (found-user :name))
  ;        (is (= "me@mytest.com" (found-user :email))))))

  ;(testing "Find by email"
  ;  (users/create {:name "John Doe" :email "j.doe@ihearttractors.com"})
  ;  (let [user (users/find-by-email "j.doe@ihearttractors.com")]
  ;    (is (= "John Doe" (user :name)))))
  )