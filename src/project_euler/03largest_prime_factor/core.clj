(ns project-euler.03largest-prime-factor.core)
;;(set! *warn-on-reflection* true)

(defn factor?
  [number x]
  (= (rem number x) 0))

(defn primes
  ([primes-so-far num]
              (if (some #(factor? num %) primes-so-far)
                (recur primes-so-far (+ num 2))
                (cons num (lazy-seq (primes (cons num primes-so-far) (+ num 2))))))
             ([] (cons 2 (primes (list 2) 3))))

(defn prime-factors
  ([number factors]
   (let [factor (first (filter (partial factor? number) (primes)))]
     (if (not= number factor)
       (recur (/ number factor) (conj factors factor))
       (conj factors factor))))
  ([number] (prime-factors number ())))

(defn largest-prime-factor
  [number]
  (first (prime-factors number)))

(prime-factors 10 ())

(defn -main
  []
  (time (println (largest-prime-factor 600851475143))))
