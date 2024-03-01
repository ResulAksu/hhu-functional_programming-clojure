(ns problems.easy.026)

(comment "Fibonacci Sequence")


(comment "Write a function which returns
the first X fibonacci numbers.")


(defn solution [x]
  (letfn [(fib-helper [a b x]
            (if (zero? x) [] 
              (cons a (fib-helper b (+ a b) (dec x)))))]
    (fib-helper 1 1 x)))



(assert (and (= (solution 3) (quote (1 1 2)))
             (= (solution 6) (quote (1 1 2 3 5 8)))
             (= (solution 8) (quote (1 1 2 3 5 8 13 21)))))
