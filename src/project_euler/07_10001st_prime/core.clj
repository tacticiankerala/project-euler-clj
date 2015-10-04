(ns project-euler.07-10001st-prime.core)

(defn prime?
  [primes-so-far num]
  (if (= 2 num)
    true
    (not-any? #(zero? (rem num %)) primes-so-far)))

(defn primes
  ([primes-so-far num]
   (if (prime? primes-so-far num)
     (cons num (lazy-seq (primes (cons num primes-so-far) (inc num))))
     (recur primes-so-far (inc num))))
  ([]
   (cons 2 (primes (list 2) 3))))

(defn nth-prime
  [n]
  (nth (primes) (dec n)))

(defn -main
  []
  (time (println (nth-prime 10001))))
