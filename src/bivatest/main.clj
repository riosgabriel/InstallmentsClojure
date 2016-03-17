(ns bivatest.main
  (:use bivatest.calculate))

(defn -main []
  "I can say 'Hello World'."
  (println (calculatePrice 1000.0 0.03 4)))