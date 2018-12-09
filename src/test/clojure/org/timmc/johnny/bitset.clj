(ns org.timmc.johnny.bitset
  "Testing bitsets."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny.internal Constants ImmutableBitSet BitSetUtils)))

;; TODO generative testing for behavioral equivalency to j.u.BitSet

(def e ImmutableBitSet/EMPTY)

(defn els
  [bs]
  (iterator-seq (.iterator bs)))

(deftest base-case
  (is (= (.isEmpty e) true))
  (is (= (.length e) 0))
  (is (= (.cardinality e) 0))
  (is (= (.size e) 0))
  (is (= (.get e 5) false))
  (is (= (.get e 20 30) e))
  (is (= (.and e e) e))
  (is (= (.or e e) e))
  (is (= (.andNot e e) e))
  (is (= (.intersects e e) false))
  (is (empty? (els e)))
  (is (= (.nextSetBit e 0) -1))
  (is (= (.nextClearBit e 0) 0))
  (is (= (.clone e) e)))

(deftest solid
  (let [ten (.set e 0 10)]
    (is (= (.isEmpty ten) false))
    (is (= (.length ten) 10))
    (is (= (.cardinality ten) 10))
    (is (= (.get ten 5) true))
    (is (= (.get ten 5 15) (.set e 0 5)))
    (is (= (.and ten ten) ten))
    (is (= (.or ten ten) ten))
    (is (= (.andNot ten ten) e))
    (is (= (.intersects ten ten) true))
    (is (= (.intersects ten (.set e 50)) false))
    (is (= (els ten) (range 10)))
    (is (= (.nextSetBit ten 0) 0))
    (is (= (.nextClearBit ten 0) 10))
    (is (= (.clone ten) ten))))

(deftest modified
  (let [ten (.set e 0 10)
        fives (-> e (.set 5) (.set 10) (.set 15))]
    (is (= (els (.and ten fives))
           [5]))
    (is (= (els (.or ten fives))
           [0 1 2 3 4 5 6 7 8 9 10 15]))
    (is (= (els (.andNot ten fives))
           [0 1 2 3 4   6 7 8 9]))
    (is (= (els (.xor ten fives))
           [0 1 2 3 4   6 7 8 9 10 15]))
    (is (= (.intersects ten fives) true))
    (is (= (.flip ten 9)
           (.set e 0 9)
           (.clear ten 9)))
    (is (= (.flip ten 5 10) (.set e 0 5)))
    (is (= (.flip ten 1 11) (-> e (.set 0) (.set 10))))
    (is (= (.flip ten 4 7)
           (.set ten 4 7 false)
           (.clear ten 4 7)))
    (is (= (.flip ten 15 20) (.set ten 15 20 true)))
    (is (= (.hashCode ten)
           (.hashCode (-> e (.set 0 5) (.set 5 10)))))
    (is (not= (.hashCode ten)
              (.hashCode (.set e 0 9))))))

(deftest char-utils
  ;; NB: A test failure in a nested 'are block can cause some spurious
  ;; failures for remaining tests in the block.
  (are [i o] (are [pre] (is (= (BitSetUtils/fromChars (pre i)) o))
                  identity
                  char-array)
       ""       e
       "\u0000" (.set e 0)
       ;; TODO: Test surrogate pairs, or leave unspecified?
       " ℠"     (-> e (.set 0x20) (.set 0x2120))))

(defn char-range-i
  "Inclusive range of char codes."
  [from to]
  (range (int from) (inc (int to))))

(deftest constants
  (is (= (.cardinality Constants/ASCII) 128))
  (is (= (.cardinality Constants/ASCII_C0) 32))
  (is (= (.cardinality Constants/ASCII_CONTROL) 33))
  (is (= (.intersects Constants/ASCII_CONTROL Constants/ASCII_PRINTABLE)
         false))
  (is (= (set (els (Constants/ASCII_ALPHANUMERIC)))
         (set (concat (char-range-i \a \z)
                      (char-range-i \A \Z)
                      (char-range-i \0 \9)))))
  (is (= (set (els (-> Constants/ASCII_PRINTABLE
                       (.andNot Constants/RFC3986_RESERVED)
                       (.andNot Constants/RFC3986_UNRESERVED))))
         (set (map int " \"%<>\\^`{|}")))))
