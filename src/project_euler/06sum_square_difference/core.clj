(ns project-euler.06sum-square-difference.core)

(defn square
  [n]
  (* n n))

(defn sum-of-squares
  [upto]
  (reduce #(+ %1 (square %2)) (range 1 (inc upto))))

(defn square-of-sum
  [upto]
  (square (reduce + (range 1 (inc upto)))))

(defn difference
  [upto]
  (- (square-of-sum upto) (sum-of-squares upto)))

(defn -main
  []
  (time (println (difference 100))))
