(ns bivatest.db)
(use 'korma.db)

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user "gabriel"
   :password "rios"
   :subname "//localhost:5432/biva"})

(defdb korma-db db)
