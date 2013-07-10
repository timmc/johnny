(ns com.brightcove.johnny.http.defaults
  "Tests for default implementations."
  (:require [clojure.test :refer :all])
  (:import (com.brightcove.johnny.http Urls)))

(deftest immutable-url-by-default
  (let [orig (Urls/parse "http://brightcove.com")
        alt (.withHost orig "example.net")]
    (testing "Original unaltered"
      (is (= (str orig) "http://brightcove.com")))
    (is (= (str alt) "http://example.net"))))
