(ns problems.elementary.008)

(comment "Sets")

(comment "Sets are collections of unique values.")

(def solution (set (quote(:a :b :c :d))))


(assert (and (= solution (set (quote (:a :a :b :c :c :c :c :d :d))))
             (= solution (clojure.set/union #{:c :b :a} #{:c :b :d}))))

