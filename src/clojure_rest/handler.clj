(ns clojure-rest.handler
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:use clojure-rest.calculate)
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [clojure.java.jdbc :as sql]
            [compojure.route :as route]))

(defn getInstallment [id] (response {:status 200 :id id :calc (calculate 1 2)}) )

(defn createInstallment [installment] ({:status 200
                                        :message "Created"}))

(defn deleteInstallment [id] (response {:status 200
                                        :message (str "Deleted: " id)}))

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
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))