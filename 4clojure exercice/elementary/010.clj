(ns problems.elementary.010)

(comment "Maps")


(comment "Maps store key-value pairs.
Both maps and keywords can be used as lookup functions.
Commas are whitespace.")


(def solution (:b {:a 10 :b 20 :c 30}))

(def person  {:name "Resul" :age 22 })

person

(assert (and (= solution ((hash-map :a 10 :b 20 :c 30) :b))
             (= solution (:b {:a 10, :b 20, :c 30}))))
