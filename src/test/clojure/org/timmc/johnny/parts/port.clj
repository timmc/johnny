(ns org.timmc.johnny.parts.port
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls)))

(deftest port-parsing
  (testing "basic parsing"
    (let [u (Urls/parse "http://example.com:8080/path")]
      (is (= (.getPortRaw u) "8080"))
      (is (= (.getPort u) 8080))
      ;; round-trips to same
      (is (= (.format u) "http://example.com:8080/path"))))
  (testing "reasonable bounds"
    (let [u (Urls/parse "http://example.com:0")]
      (is (= (.getPortRaw u) "0"))
      (is (= (.getPort u) 0))
      (is (= (.format u) "http://example.com:0")))
    (testing "at least as high as Integer/MAX_VALUE" ;; TODO: higher?
      (let [u (Urls/parse "http://example.com:2147483647")]
        (is (= (.getPortRaw u) "2147483647"))
        (is (= (.getPort u) 2147483647))
        (is (= (.format u) "http://example.com:2147483647"))))))

#_ ;; TODO: Port normalization
(deftest normalization
  (testing "strip leading zeroes, and parse in decimal"
    (let [u (Urls/parse "http://example.com:0020")]
      (is (= (.getPortRaw u) "0020"))
      (is (= (.getPort u) 20))
      (is (= (.format u) "http://example.com:20")))))

;; "scheme-based normalization"
(deftest redundant-port
  ;; RFC 3986 §3.2.3: URI producers and normalizers should omit the
  ;; port component and its ":" delimiter if port is empty or if its
  ;; value would be the same as that of the scheme's default.
  (testing "empty port"
    (let [empty (Urls/parse "http://example.com:/path")]
      (is (= (.getPortRaw empty) ""))
      (is (= (.getPort empty) nil))
      (is (= (.format empty) "http://example.com/path"))))
  (testing "missing port"
    (let [missing (Urls/parse "http://example.com/path")]
      (is (= (.getPortRaw missing) nil))
      (is (= (.getPort missing) nil))
      (is (= (.format missing) "http://example.com/path"))))
  (testing "default port"
    ;; TODO: Test that ports 80 and 443 are omitted when formatting
    ;; http and https URIs, respectively. Maybe other common
    ;; protocols?
    ))
