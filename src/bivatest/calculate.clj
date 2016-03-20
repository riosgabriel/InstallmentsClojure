(ns bivatest.calculate)

(defn ^:dynamic ** [x n] (reduce * (repeat n x)))

;(defn calculate [x y] (+ x y))

(defn calculatePrice [pv i n]
  (* pv
     (/
       (* (** (+ 1 i) n) i)
       (- (** (+ 1 i) n) 1))))

(defn calculatePrice2 [pv i n]
  (/
    (* pv i)
    (- 1
       (/ 1
          (** (+ 1 i) n)))))