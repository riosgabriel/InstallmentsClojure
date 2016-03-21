(ns bivatest.db.db)
(use 'korma.db)
(require '[environ.core :refer [env]])

(def database-url
  (env :database-url))

(def database-user
  (env :database-user))

(def database-password
  (env :database-password))

(def db
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :user database-user
   :password database-password
   :subname database-url})

(defdb korma-db db)
