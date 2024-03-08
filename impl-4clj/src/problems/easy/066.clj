(ns problems.easy.066)

(comment "Greatest Common Divisor")


(comment "Given two integers, write a function which
returns the greatest common divisor.")


(defn solution
  [int1 int2]
  (if (zero? int1)
    int2
    (recur (mod int2 int1) int1)))



(assert (and (= (solution 2 4) 2)
             (= (solution 10 5) 5)
             (= (solution 5 7) 1)
             (= (solution 1023 858) 33)))
