(ns org.timmc.johnny.defaults
  "Tests for default implementations."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls)))

(deftest immutable-url-by-default
  (let [orig (Urls/parse "http://brightcove.com")
        alt (.withHostRaw orig "example.net")]
    (testing "Original unaltered"
      (is (= (.format orig) "http://brightcove.com")))
    (is (= (.format alt) "http://example.net"))))
