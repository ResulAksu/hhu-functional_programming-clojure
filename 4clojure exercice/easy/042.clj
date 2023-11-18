(ns problems.easy.042)

(comment "Factorial Fun")

(comment "Write a function which calculates factorials.")


(defn solution [n]
  (reduce * (range 1 (inc n))))


(assert (and (= (solution 1) 1)
             (= (solution 3) 6)
             (= (solution 5) 120)
             (= (solution 8) 40320)))
