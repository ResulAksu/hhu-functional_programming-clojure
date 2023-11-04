(ns problems.easy.026)

(comment "Fibonacci Sequence")


(comment "Write a function which returns
the first X fibonacci numbers.")


(defn solution
  [args]
  (take args (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))
  )

(comment "iterate fn anfangswert hier anfangswert [1 1] und die Funktion sagt
          addiere beide für den nächsten Wert")

(comment "Was passiert ist iterate macht bei beispielsweise n=3 
          [1 1]"
         "map nimmt first also 1 zweimal"
         "nächster iterate"
         "[2 1 1]"
         "map nimmt first also 2"
         "=> coll : [1 1 2]")
(comment "Take nimmt die ersten args Zahlen")


(def fib-seq
  (lazy-cat [1 1] (map + (rest fib-seq) fib-seq)))

(defn fibonacci-lazy
  [n]
  (take n fib-seq))

(comment "In other words, if you were to keep calling 
          (take ... fib-seq) in a long-running program, you would eventually
          run out of memory, because fib-seq is an infinite sequence
          and the garbage collector would not be able to free any of it,
          since the initial reference (fib-seq itself) is never released.")

(assert (and (= (fibonacci-lazy 3) (quote (1 1 2)))
             (= (solution 6) (quote (1 1 2 3 5 8)))
             (= (solution 8) (quote (1 1 2 3 5 8 13 21)))))

