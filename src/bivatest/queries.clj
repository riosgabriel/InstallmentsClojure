(ns bivatest.queries
    (:use bivatest.db))
(use '[datomic.api :only [q db] :as d])

(defn select-all [](d/q '[:find ?e
                          :where
                          [?e :installment/uuid #uuid "45b931f7-e9a7-4b6a-b156-cb2a615d10eb"]]
                        (d/db conn)))

(defn select-by-present_value [value] (d/q '[:find ?e
                                             :where
                                             [?e :installment/present_value value]
                                             ] (d/db (d/connect uri))))

(defn to-uuid [id] (str (java.util.UUID/fromString id)))

(defn new-uuid [] (java.util.UUID/randomUUID))

(defn select-by-id [id] (d/q '[:find ?e
                               :where
                               [?e :installment/uuid (to-uuid id)]]
                             (d/db conn)))

(defn get-entity [eid] (d/entity (d/db conn) (ffirst eid)))
