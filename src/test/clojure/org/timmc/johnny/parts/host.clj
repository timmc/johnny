(ns org.timmc.johnny.parts.host
  "Tests for host parsing."
  (:require [clojure.test :refer :all])
  (:import org.timmc.johnny.http.Urls
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
