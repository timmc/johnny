(ns com.brightcove.johnny.mutable
  "Tests for mutable implementation."
  (:require [clojure.test :refer :all])
  (:import (com.brightcove.johnny MutableHttpUrl)))

(deftest chaining-optional
  (let [make-orig (constantly (MutableHttpUrl/from "http://brightcove.com"))]
    (is (= (str (doto (make-orig)
                  (.setHost "localhost")
                  (.setFragment "frag")))
           (str (-> (make-orig)
                    (.withHost "localhost")
                    (.withFragment "frag")))))))
