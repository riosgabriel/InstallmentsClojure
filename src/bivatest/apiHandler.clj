(ns bivatest.apiHandler
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:use bivatest.calculate)
  (:use bivatest.queries)
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [clojure.java.jdbc :as sql]
            [compojure.route :as route]))

(defn getInstallment [id] (response (select-by-present_value id)))

(defn createInstallment [installment]
  (let
    [value   (get installment :present_value 0)
     number (get installment :number_of_installments)
     rate (get installment :monthly_interest_rate)]
    (response {:present_value value
               :number_of_installments number
               :monthly_interest_rate rate})))

(defn deleteInstallment [id] (response {:status 200
                                        :message (str "Deleted: " id)}))

(defroutes app-routes
           (context "/installment" [] (defroutes installment-routes
               ;body é provido pelo wrap-json-body do middleware
               (POST "/" {body :body} (createInstallment body))

               (context "/:id" [id] (defroutes installment-routes
                   (GET    "/" [] (getInstallment id))
                   (DELETE "/" [] (deleteInstallment id))))))

           (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))