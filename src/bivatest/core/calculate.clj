(ns bivatest.core.calculate)

(defn ^:dynamic ** [x n] (reduce * (repeat n x)))

(defn calculatePrice [pv i n]
  (if (or (<= i 0) (<= n 0))
     0
     (/
       (* pv i)
       (- 1
          (/ 1
             (** (+ 1 i) n))))))