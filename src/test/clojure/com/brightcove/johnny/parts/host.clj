(ns com.brightcove.johnny.parts.host
  "Tests for host parsing."
  (:require [clojure.test :refer :all])
  (:import com.brightcove.johnny.http.Urls
           com.brightcove.johnny.parts.Host
           java.net.InetAddress
           com.google.common.net.InternetDomainName))

(deftest invariants
  (let [ip4 (InetAddress/getByName "4.4.4.4")
        ip4h (Host. ip4)]
    (is (.isIp ip4h))
    (is (= (.getIp ip4h) ip4)))
  (let [ip6 (InetAddress/getByName "::1")
        ip6h (Host. ip6)]
    (is (.isIp ip6h))
    (is (= (.getIp ip6h) ip6)))
  (let [dom (InternetDomainName/from "example.net")
        domh (Host. dom)]
    (is (.isDomain domh))
    (is (= (.getDomain domh) dom))))

(deftest which
  ;; Test component parsing in full-url-parsing context
  ;; to ensure that decoding happens.
  (let [p #(.getHost (Urls/parse (str "http://" %)))]
    (are [in out] (case out
                    :domain (is (.isDomain (p in)))
                    :ip (is (.isIp (p in)))
                    :inv (is (thrown? Exception (p in))))
         "www.example.com." :domain
         "localhost" :domain
         #_ (comment ;; JNUriParser rejects this
              "➡.ws" :domain)
         "xn--hgi.ws." :domain
         "www" :domain
         "www.." :inv
         ".localhost" :inv
         "256.com" :domain
         "192.168.1.115" :ip
         #_ (comment ;; Guava rejects this -- investigate
              "192.168.001.115" :ip)
         "[::1]" :ip
         "::1" :inv
         "[::1" :inv
         #_ (comment ;; TODO: zone IDs (Guava's InetAddresses lacks support)
              "[0:4::1%25eth0]" :ip
              "[0:4::1%eth0]" :inv))))
