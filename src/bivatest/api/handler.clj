(ns bivatest.api.handler
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:use bivatest.model.entities)
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [compojure.route :as route]))

(defn bad-request [message] {:status 400
                             :body {:message message}
                             :headers {"Content-Type" "application/json"}})

(defn is-valid-param? [n] (and (not (nil? n)) (> n 0)))


(defn getInstallment [id] (let [result (select-by-id id)]
                            (cond
                              (empty? result) {:status 404
                                               :headers {"Content-Type" "application/json"}}
                              :else (response result))))

(defn createInstallment [installment]
  (let
    [present (get installment :present_value)
     number (get installment :number_of_installments)
     rate (get installment :monthly_interest_rate)]
     (if (not (is-valid-param? rate))
       (bad-request "monthly_interest_rate must be grater than zero")
       (if (not (is-valid-param? number))
        (bad-request "number_of_installments must be grater than zero")
        (response (select-keys (add present rate number)  [:installment_value :id]))))))

(defn deleteInstallment [id] (let [result (delete-by-id id)]
                               (cond
                                 (empty? result) {:status 404
                                                  :headers {"Content-Type" "application/json"}}
                                  :else {:status 204
                                         :headers {"Content-Type" "application/json"}})))

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