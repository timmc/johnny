(ns org.timmc.johnny.bitset
  "Testing bitsets."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny.internal Constants ImmutableBitSet)))

(defn els
  [bs]
  (iterator-seq (.iterator bs)))

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
