(ns org.timmc.johnny.parts.userinfo
  "Tests for userinfo parsing."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls UserPass)
           (org.timmc.johnny.internal Constants UserPassParser)))

(deftest parsing
  (let [parse (fn [raw] (let [ui (UserPassParser/parse raw)]
                          [(.user ui) (.password ui)]))]
    (are [in out] (= (parse in) out)
         "" ["" nil]
         ":" ["" ""]
         "::::" ["" ":::"]
         "%25" ["%" nil]
         "ab%3Acd:ef%3Agh:ij" ["ab:cd" "ef:gh:ij"]
         "%E0%A5%AE:%E0%A5%AF" ["\u096e" "\u096f"]))
  (testing "nil handling"
    (is (thrown? NullPointerException (UserPassParser/parse nil)))
    (is (= (.getUserPass (Urls/parse "http://localhost"))))))

(deftest formatting
  (let [fmt (fn [[u p]] (let [ui (UserPass. u p)]
                          (.format ui)))]
    (are [in out] (= (fmt in) out)
         ["" nil] ""
         ["" ""] ":"
         ["" ":::"] "::::"
         ["%" nil] "%25"
         ["ab:cd" "ef:gh:ij"] "ab%3Acd:ef:gh:ij"
         ["\u096e" "\u096f"] "%E0%A5%AE:%E0%A5%AF")
    (testing "minimality"
      (let [interesting (map char
                             (iterator-seq
                              (.iterator
                               (.andNot Constants/ASCII
                                        Constants/ASCII_ALPHANUMERIC))))]
        (testing "username"
          (is (= (set (remove #(.contains (fmt [(str %) ""]) "%")
                              interesting))
                 (set "-._~!$&'()*+,;="))))
        (testing "password (adds colon)"
          (is (= (set (remove #(.contains (fmt ["" (str %)]) "%")
                              interesting))
                 (set "-._~!$&'()*+,;=:")))))))
  (testing "null rejection"
    (is (thrown? NullPointerException
                 (.format nil)))))

(deftest object-overrides
  (let [up-a1 (UserPassParser/parse "a:b")
        up-a2 (UserPassParser/parse "a:b")
        up-b (UserPassParser/parse "c:d")
        u-a1 (UserPassParser/parse "a")
        u-a2 (UserPassParser/parse "a")
        u-b (UserPassParser/parse "c")]
    (testing "equality"
      (testing "segregated by password nil/not nil"
        (is (= up-a1 up-a2))
        (is (= u-a1 u-a2)))
      (testing "inequality"
        (is (not (= up-a1 up-b)))
        (is (not (= u-a1 u-b))))
      (testing "password is also compared"
        (is (not (= up-a1 u-a1)))))
    (testing "hashes"
      (is (= (.hashCode up-a1) (.hashCode up-a2)))
      (testing "possibly fragile, but test mismatch anyhow"
        (is (not (= (.hashCode up-a1) (.hashCode up-b))))))))
