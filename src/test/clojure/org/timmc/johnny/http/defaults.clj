(ns org.timmc.johnny.http.defaults
  "Tests for default implementations."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny.http Urls)))

(deftest immutable-url-by-default
  (let [orig (Urls/parse "http://brightcove.com")
        alt (.withHostRaw orig "example.net")]
    (testing "Original unaltered"
      (is (= (str orig) "http://brightcove.com")))
    (is (= (str alt) "http://example.net"))))
