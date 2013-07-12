(ns com.brightcove.johnny.coll.concat
  (:use clojure.test)
  (:import com.brightcove.johnny.coll.Concat))

(deftest reinvent-concat-badly
  (testing "with both nil"
    (doseq [[a b] [[nil nil]
                   [[] []]]]
      (let [it (.iterator (Concat. a b))]
        (is (not (.hasNext it)))
        (testing "and hasNext repeatable"
          (is (not (.hasNext it)))))))
  (testing "no state between iterators"
    (let [make #(.iterator (Concat. [1 2] [3 4]))
          a (make)
          b (make)]
      (is (.hasNext a))
      (is (.hasNext b))
      (dorun (iterator-seq a))
      (is (.hasNext b))
      (is (not (.hasNext a)))))
  (testing "nil start or end"
    (doseq [[a b] [[nil [1 2 3]
                    [] [1 2 3]
                    [1] [2 3]
                    [1 2 3] []
                    [1 2 3] nil]]]
      (let [it (.iterator (Concat. a b))]
        (is (= (iterator-seq it)
               (concat a b)))))))
