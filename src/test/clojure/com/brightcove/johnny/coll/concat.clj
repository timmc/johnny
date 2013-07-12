(ns com.brightcove.johnny.coll.concat
  (:use clojure.test)
  (:import com.brightcove.johnny.coll.Concat))

(deftest reinvent-concat-badly
  (doseq [[a b] [[nil [1 2 3]
                  [1] [2 3]
                  [1 2 3] nil]]]
    (is (= (iterator-seq (.iterator (Concat. a b)))
           (concat a b)))))
