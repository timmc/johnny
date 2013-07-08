(ns com.brightcove.johnny.immutable
  "Tests for immutable implementation."
  (:require [clojure.test :refer :all])
  (:import (com.brightcove.johnny HttpUrls)))

(deftest immutable-by-default
  (let [orig (HttpUrls/from "http://brightcove.com")
        alt (.withHost orig "example.net")]
    (testing "Original unaltered"
      (is (= (str orig) "http://brightcove.com")))
    (is (= (str alt) "http://example.net"))))
