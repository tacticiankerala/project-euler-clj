(ns project-euler.01multiples.core)

(defn multiple?
  [num quantity]
  (= (rem num quantity) 0))

(defn multiple-of-three-or-five?
  [num]
  (some #(multiple? num %1) [3 5]))

(defn sum
  [upto]
  (apply + (for [x (range upto) :when (multiple-of-three-or-five? x)] x))
)
(defn -main
  []
  (time (println (sum 1000))))
