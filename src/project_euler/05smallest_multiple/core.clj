(ns project-euler.05smallest-multiple.core)

(defn gcd [a b] (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b] (/ (* a b) (gcd a b)))

(defn prime?
  [number]
  (let [factors (range 2 (inc (Math/floor (Math/sqrt number))))]
    (not-any? #(= (rem number %1) 0) factors)))


(defn smallest-multiple
  [divisor-range]
  (let [composite-divisors (filter (complement prime?) divisor-range)]
    (reduce lcm divisor-range)))

(defn -main
  []
  (time (println (smallest-multiple (range 1 21)))))
