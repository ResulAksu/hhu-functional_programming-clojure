(ns problems.elementary.017)

(comment "map")


(comment "The map function takes two arguments:
a function (f) and a sequence (s).
Map returns a new sequence consisting of
the result of applying f to each item of s.
Do not confuse the map function with the map data structure.")


(def solution  '(6 7 8))

(assert (and (= solution (map (fn* [s] (+ s 5)) (quote (1 2 3))))))
