(ns bivatest.db)
(use '[datomic.api :only [q db] :as d])

(def uri "datomic:free://localhost:4334/biva-db")

(def conn (d/connect uri))



