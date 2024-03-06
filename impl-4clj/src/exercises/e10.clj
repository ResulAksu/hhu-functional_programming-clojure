(comment "Exercise 10.1 (Minesweeper)
Implement Minesweeper (see https://de.wikipedia.org/wiki/Minesweeper, https://www.youtube.com/watch?v=LHY8NKj3RKs).

At least the following functions shall be available on the REPL:
• (init! height width amount-of-mines) should initialize the playing field with corresponding
  height, width and number of mines. Additionally (init!) should use 30 as default value for the
  height, 16 for the width and 99 for the number of mines.

Note: the function shuffle could be useful.

• (reveal! x y) uncovers the field at coordinate (x,y). If a mine happens to be there, the game
  is lost. If there is no mine in the surrounding area of this field, all fields around it should
  be uncovered automatically. (and analogously for the neighbours of those fields, if there are
  also no mines in the surrounding area).

• (flag! x y) should mark the field at (x,y) as mine or remove this mark if it already was marked.
  Marked fields cannot be uncovered by reveal!.

• (print-board!) should output the board in an appropriate format.

Note: This requires the use of time management construct. Make sure that no inconsistent state can occur.
Note: Yes, it is somewhat ugly to extract the fields surrounding a given field.
")

(defn l_v [matrix]
  (vec(map vec matrix)))

(defn init!
  ([] (init! 30 16 99))
  ([height width mines] (def playfield (atom 
  (let [total-cells (* height width)
        mine-positions (take mines (shuffle (range total-cells)))] 
    (l_v (partition width 
               (map  #(if (some #{%} mine-positions) "B" "X") 
                    (range total-cells)))))))))

(defn print-board! []
  (doseq [x @playfield] (prn x)))

(defn toggle-flag [cell]
  (if (= cell "F") "X" "F"))

(defn flag! [x y]
  (let [x (- x 1) y (- y 1)]
  (swap! playfield update-in [x y] toggle-flag)))


(defn reveal! [x y]
  (let [x (- x 1) y (- y 1)]
  (if (not= (get-in @playfield [y x]) "B") (
    (let [coords [[0 0] [-1 -1] [-1 0] [-1 1] [0 -1] [0 1] [1 -1] [1 0] [1 1]]] ; Relative coordinates of surrounding cells
      (doseq [coord coords]
        (let [nx (+ x (first coord)) 
              ny (+ y (second coord))] 
          (prn nx ny)
          (when (and (>= nx 0) (< nx (count @playfield)) ; Check boundaries
                     (>= ny 0) (< ny (count (first @playfield))))
            (if (not= (get-in @playfield [ny nx]) "B") ; If not a bomb
              (swap! playfield assoc-in [ny nx] "R"))))))) (prn "You lose")))) ; Reveal cell


(init!)
(flag! 2 2)
(print-board!)
(reveal! 1 1)

