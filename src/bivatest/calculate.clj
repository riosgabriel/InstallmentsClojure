(ns bivatest.calculate)

(defn ^:dynamic ** [x n] (reduce * (repeat n x)))

(defn calculate [x y] (+ x y))

(defn calculatePrice [pv i n]
  (* (/ (* (** (+ 1 i) n) i) (- (** (+ 1 i) n) 1)) pv))

