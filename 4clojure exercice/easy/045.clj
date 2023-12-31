(ns problems.easy.045)

(comment "Intro to Iterate")


(comment "The iterate function can be used to produce
an infinite lazy sequence.")


(def solution '(1 4 7 10 13))

(assert (and (= solution (take 5 (iterate #(+ 3 %) 1)))))
