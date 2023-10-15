(ns problems.elementary.007)

(comment "conj on vectors")


(comment "When operating on a Vector,
the conj function will return a new vector
with one or more items "added" to the end.")


(def solution [1 2 3 4])
(def solution1 (vec(quote(1 2 3 4))))
(def solution2 (vector 1 2 3 4))


(assert (and (= solution (conj [1 2 3] 4))
             (= solution (conj [1 2] 3 4))))
(assert (and (= solution1 (conj [1 2 3] 4))
             (= solution1 (conj [1 2] 3 4))))
(assert (and (= solution2 (conj [1 2 3] 4))
             (= solution2 (conj [1 2] 3 4))))
