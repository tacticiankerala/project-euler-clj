(ns project-euler.10summation-of-primes.core
  (:require [clojure.set]))

;;Sieve Eratosthenes is a good way to generate primes fast - https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

(defn multiples
  [num limit]
  (for [i (range 1 (inc (Math/ceil (float (/ limit num)))))]
    (* i num)))

(defn sum-primes
  ([prime-candidates-sorted-set limit sum]
   (if-let [prime (first prime-candidates-sorted-set)]
     (let [prime-multiples (set (multiples prime limit))
           new-prime-candidates (clojure.set/difference prime-candidates-sorted-set
                                                        prime-multiples)]
       (recur new-prime-candidates limit (+ sum prime)))
     sum))
  ([limit]
   (sum-primes (apply sorted-set (range 3 limit 2)) limit 2)))

(defn -main
  []
  (time (println (sum-primes 2000000))))
