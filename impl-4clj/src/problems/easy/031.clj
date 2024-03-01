(ns problems.easy.031)

(comment "Pack a Sequence")


(comment "Write a function which
packs consecutive duplicates into sub-lists.")


(defn solution [args] 
    (reduce (fn [acc item]
              (if (and (not-empty acc) (= (last (last acc)) item))
                (update-in acc [(dec (count acc))] conj item)
                (conj acc [item])))
            []
            args))



(assert (and (= (solution [1 1 2 1 1 1 3 3]) (quote ((1 1) (2) (1 1 1) (3 3))))
             (= (solution [:a :a :b :b :c]) (quote ((:a :a) (:b :b) (:c))))
             (= (solution [[1 2] [1 2] [3 4]]) (quote (([1 2] [1 2]) ([3 4]))))))

(solution [1 1 2 1 1 1 3 3])