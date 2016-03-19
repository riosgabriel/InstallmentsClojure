(ns bivatest.main
  (:use bivatest.calculate
    :use bivatest.queries))

(defn -main []
  "I can say 'Hello World'."
  (println (calculatePrice 1000.0 0.03 4))
  (println (seq (get-entity (select-all))))
  (println (get-entity (select-by-present_value (bigdec 1000)))))