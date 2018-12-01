(ns org.timmc.johnny.defaults
  "Tests for default implementations."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls RegNameHost)))

(deftest immutable-url-by-default
  (let [orig (Urls/parse "http://brightcove.com")
        alt (.withHost orig (RegNameHost. "example.net"))]
    (testing "Original unaltered"
      (is (= (.format orig) "http://brightcove.com")))
    (is (= (.format alt) "http://example.net"))))
