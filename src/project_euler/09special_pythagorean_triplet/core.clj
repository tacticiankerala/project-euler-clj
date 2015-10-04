(ns project-euler.09special-pythagorean-triplet.core)

(defn square
  [n]
  (* n n))

(defn is-pythogorean-triplet?
  [a b c]
  (= (+ (square a)
        (square b))
     (square c)))

(defn pythogorean-triplets
  [upto]
  (for [a (range 1 (dec upto))
        b (range (inc a) upto)
        c (range (inc b) (inc upto))
        :when (is-pythogorean-triplet? a b c)]
    [a b c]))

(defn pythogorean-triplet-which-sums-to
  [num]
  (first (filter #(= num (apply + %1)) (pythogorean-triplets num))))

(defn -main
  []
  (time (println (apply * (pythogorean-triplet-which-sums-to 1000)))))
