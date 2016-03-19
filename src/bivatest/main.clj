(ns bivatest.main
  (:use bivatest.calculate
   :use bivatest.entities))

(defn -main []
  "I can say 'Hello World'."
  (println (calculatePrice 1000.0 0.03 4)
           println {:value (select-all) :status 200}))