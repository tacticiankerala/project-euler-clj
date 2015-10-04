(ns project-euler.04largest-palindrome-product.core)

(defn palindrome?
  [number]
  (let [number-str (str number)]
    (= number-str (clojure.string/reverse number-str))))

(defn largest-palindrome-product
  ([factor-range]
   (reduce max (for [x factor-range y factor-range :when (palindrome? (* x y))] (* x y))))
  ([] (largest-palindrome-product (range 999 0 -1))))

(defn -main
  []
  (time (println (largest-palindrome-product))))
