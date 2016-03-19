(ns bivatest.db)
(use 'korma.db)
(require '[clojure.string :as str])

;(defdb db (postgres {:db "biva"
;                     :user "gabriel"
;                     :password "rios"
;                     :host "localhost"
;                     :port "5432"
;                     :delimiters ""
;                     :naming {:keys str/lower-case
;                              :fields str/upper-case}}))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user "gabriel"
   :password "rios"
   :subname "//localhost:5432/biva"})

(defdb korma-db db)