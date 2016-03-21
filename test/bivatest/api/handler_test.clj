(ns bivatest.api.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure.data.json :as json]
            [bivatest.api.handler :refer :all]))

(def rate-zeroed-message "{\"message\":\"monthly_interest_rate must be grater than zero\"}")
(def installment-zeroed-message "{\"message\":\"number_of_installments must be grater than zero\"}")

(deftest test-app
  (testing "get route"
    (let [response (app (mock/request :get "/installment/de305d54-75b4-431b-adb2-eb6b9e546014"))]
      (is (= (:status response) 404))
      (is (= (get-in response [:headers "Content-Type"]) "application/json"))))

  (testing "post route with rate zeroed")
      (let [response
        (app
          (mock/content-type (mock/body
                               (mock/request :post "/installment")
                               (json/write-str {:present_value 1000.00
                                                :number_of_installments 1
                                                :monthly_interest_rate 0 }))
                             "application/json"
                             ))]
      (is (= (:body response) rate-zeroed-message)))

  (testing "post route with number of installment zeroed")
      (let [response
        (app
          (mock/content-type (mock/body
                               (mock/request :post "/installment")
                               (json/write-str {:present_value 1000.00
                                                :number_of_installments 0
                                                :monthly_interest_rate 0.01 }))
                             "application/json"
                             ))]
      (is (= (:body response) installment-zeroed-message)))

  (testing "not-found route"
    (let [response (app (mock/request :get "/not-found"))]
      (is (= (:status response) 404))))
  )
