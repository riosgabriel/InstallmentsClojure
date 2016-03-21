(ns bivatest.main
  (:use bivatest.calculate
   :use bivatest.entities
   :use bivatest.handler))

(defn is-valid-param2? [n] (and (not (nil? n)) (> n 0)))

(require '[environ.core :refer [env]])

(def database-url
  (env :database-url))

(defn -main []
  "I can say 'Hello World'."
  (println (is-valid-param2? nil))
  (println (env :database-url))
  (println database-url)
  ;(println (calculatePrice2 1000.0 0.03 4)
  ;(println (calculatePrice 2500.0 0.07 10)
  ;(println {:value (select-by-id "ffa91b0a-3ccd-4efe-8964-3787fe5d637d") :status 200}))
  ;(println {:status "deleted" :opt (delete-by-id "6d0024dd-fa51-4325-a0f9-97092a1e736d") })
  ;(println {:status "inserting" :opt (add 2500 0.07 10)})
  )
