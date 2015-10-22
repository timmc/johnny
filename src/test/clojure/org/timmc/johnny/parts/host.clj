(ns org.timmc.johnny.parts.host
  "Tests for host parsing."
  (:require [clojure.test :refer :all])
  (:import org.timmc.johnny.Urls
           org.timmc.johnny.parts.Host
           java.net.InetAddress
           com.google.common.net.InternetDomainName))

(deftest invariants
  (let [mk-ip4 #(InetAddress/getByName "4.4.4.4")
        ip4h (Host. (mk-ip4))
        mk-ip6 #(InetAddress/getByName "::1")
        ip6h (Host. (mk-ip6))
        mk-dom #(InternetDomainName/from "example.net")
        domh (Host. (mk-dom))]
    (testing "isX"
      (is (.isIp ip4h))
      (is (.isIp ip6h))
      (is (.isDomain domh)))
    (testing "getX"
      (is (= (.getIp ip4h) (mk-ip4)))
      (is (= (.getIp ip6h) (mk-ip6)))
      (is (= (.getDomain domh) (mk-dom))))
    (testing "equals"
      (are [gen] (.equals (Host. (gen)) (Host. (gen)))
           mk-ip4 mk-ip6 mk-dom))
    (testing "hashcode"
      (are [gen] (.equals (.hashCode (Host. (gen)))
                          (.hashCode (Host. (gen))))
           mk-ip4 mk-ip6 mk-dom)
      (let [other-ip4 (InetAddress/getByName "8.8.8.8")]
        (are [gen] (not (.equals (.hashCode (Host. other-ip4))
                                 (.hashCode (Host. (gen)))))
             mk-ip4 mk-ip6 mk-dom)))))

(deftest encoding
  ;; "URIs that differ in the replacement of an unreserved
  ;; character with its corresponding percent-encoded US-ASCII
  ;; octet are equivalent" ― RFC 3986 §2.3
  ;; (Not that you *should* encode letters in a host name...)
  (let [h (.getHost (Urls/parse "http://www.ex%61mple.com/"))]
    (is (.isDomain h))
    ;; TODO: We're punting on this for now with .raw -- when we
    ;; actually parse this field, we'll need to confirm that the "%61"
    ;; -> "a" decode happens.
    (is (= (.raw h) "www.ex%61mple.com"))))

(deftest which
  ;; Test component parsing in full-url-parsing context
  ;; to ensure that decoding happens.
  (let [p #(.getHost (Urls/parse (str "http://" %)))]
    (are [in out] (case out
                    :domain (is (.isDomain (p in)))
                    :ip (is (.isIp (p in)))
                    :inv (is (thrown? Exception (p in))))
         ;; TODO: Add test for IPvFuture host format. (Just throw?)
         "www.example.com." :domain
         "www.ex%61mple.com." :domain
         "localhost" :domain
         ;; TODO: Add Codec variant to allow/disallow unencoded
         ;; non-ASCII in URLs.
         "➡.ws" :domain
         "%E2%9E%A1.ws" :domain
         "xn--hgi.ws." :domain
         "www" :domain
         "www.." :inv
         ".localhost" :inv
         "256.com" :domain
         "192.168.1.115" :ip
         ;; TODO: Add Codec variant to allow leading zeroes.
         "192.168.001.115" :ip ;; FIXME should be :inv for leading zeroes
         "192.168.%31.115" :ip
         "[::1]" :ip
         "[::%31]" :ip
         "::1" :inv
         "[::1" :inv
         "[0:4::1%25eth0]" :ip
         ;; Common mistake, probably -- if anyone even uses zone identifiers.
         "[0:4::1%eth0]" :inv)))
