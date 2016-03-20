(ns bivatest.main
  (:use bivatest.calculate
   :use bivatest.entities
   :use bivatest.handler))

(defn -main []
  "I can say 'Hello World'."
  ;(println (calculatePrice2 1000.0 0.03 4)
  ;(println (calculatePrice2 2500.0 0.07 10)
  (println (apply-or-error -1 #(> % 0) "error"))
  ;(println {:value (select-by-id "ffa91b0a-3ccd-4efe-8964-3787fe5d637d") :status 200}))
  ;(println {:status "deleted" :opt (delete-by-id "6d0024dd-fa51-4325-a0f9-97092a1e736d") })
  ;(println {:status "inserting" :opt (add 2500 0.07 10)})
  )