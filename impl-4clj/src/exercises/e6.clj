(ns exercises.e6)

(def g {:nodes #{:a :c :b :d :e},
        :edges #{[:b :c] 
                 [:c :e] [:a :d]
                 [:a :e] [:b :a]}})

( comment "my solution"
 (defn dom [g] (set (map first (second (map last g)))))
)

(comment "chatgpt")
(defn dom [g]
  (set (map first (:edges g))))

(defn ran [g]
  (set (map second (:edges g))))

(comment "dfs start -> new start -> new start")



(dom g)

(ran g)

(comment "(path? g :b :e)"
)