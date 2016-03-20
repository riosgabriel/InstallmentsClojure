(ns bivatest.handler
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:use bivatest.entities)
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]))

(defn >0 [n] (n > 0))

(defn apply-or-error [value pred err]
  (if (pred value) value err))

(defn getInstallment [id] (let [result (select-by-id id)]
                            (cond
                              (empty? result) {:status 404}
                              :else (response result))))

(defn createInstallment [installment]
  (let
    [present (apply-or-error (get installment :present_value 1) >0 "abc")
     number (get installment :number_of_installments 1)
     rate (get installment :monthly_interest_rate 1)]
    (response (select-keys (add present rate number)  [:installment_value :id]))))

(defn deleteInstallment [id] (let [result (delete-by-id id)]
                               (cond
                                 (empty? result) {:status 404}
                                  :else {:status 204})))

(defroutes appRoutes
           (context "/installment" [] (defroutes installment-routes
               ;body é provido pelo wrap-json-body do middleware
               (POST "/" {body :body} (createInstallment body))

               (context "/:id" [id] (defroutes installment-routes
                   (GET    "/" [] (getInstallment id))
                   (DELETE "/" [] (deleteInstallment id))))))

           (route/not-found "Not Found"))

(def app
  (-> (handler/api appRoutes)
      (middleware/wrap-json-body {:keywords? true})
      (middleware/wrap-json-response)))