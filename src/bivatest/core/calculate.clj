(ns bivatest.core.calculate)

(defn ^:dynamic ** [x n] (reduce * (repeat n x)))

(defn calculatePrice [pv i n]
  (/
    (* pv i)
    (- 1
       (/ 1
          (** (+ 1 i) n)))))