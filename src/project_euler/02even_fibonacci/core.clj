(ns project-euler.02even_fibonacci.core)

(defn fibs
  ([last2 last1] (let [new-fib (+ last1 last2)]
                    (cons new-fib (lazy-seq (fibs last1 new-fib)))))
  ([] (fibs -1 1)))

(defn even-fibs
  []
  (filter even? (fibs)))

(defn sum-even-fibs
  [upto]
  (apply + (take-while #(< %1 upto) (even-fibs))))

(defn -main
  [number]
  (let [limit (Integer/parseInt number)]
    (time (println (sum-even-fibs limit)))))
