(ns org.timmc.johnny.parts.userinfo
  "Tests for userinfo parsing."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Constants StringEncoder Urls)
           (org.timmc.johnny.parts UserInfo PluggableUserInfoEncoder)))

(defn default-parse
  [s]
  (.parse (.userInfoParser Urls/DEFAULT_CODECS) s))

(defn default-encode
  [ui]
  (.unparse (.userInfoEncoder Urls/DEFAULT_CODECS) ui))

(deftest parsing
  (let [parse (fn [raw] (let [ui (default-parse raw)]
                          [(.user ui) (.password ui)]))]
    (are [in out] (= (parse in) out)
         "" ["" nil]
         ":" ["" ""]
         "::::" ["" ":::"]
         "%25" ["%" nil]
         "ab%3Acd:ef%3Agh:ij" ["ab:cd" "ef:gh:ij"]
         "%E0%A5%AE:%E0%A5%AF" ["\u096e" "\u096f"])))

(deftest encoding
  (let [encode (fn [[u p]] (let [ui (UserInfo. u p)]
                             (default-encode ui)))]
    (are [in out] (= (encode in) out)
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
          (is (= (set (remove #(.contains (encode [(str %) ""]) "%")
                              interesting))
                 (set "-._~!$&'()*+,;="))))
        (testing "password (adds colon)"
          (is (= (set (remove #(.contains (encode ["" (str %)]) "%")
                              interesting))
                 (set "-._~!$&'()*+,;=:")))))))
  (testing "alt encoders"
    (let [bad (reify StringEncoder
                (encode [_this s] "_"))]
      (is (= (.unparse (PluggableUserInfoEncoder. bad bad)
                       (UserInfo. "123" "abc"))
             "_:_"))))
  (testing "null rejection"
    (is (thrown? NullPointerException
                 (default-encode nil)))))

(deftest object-overrides
  (let [up-a1 (default-parse "a:b")
        up-a2 (default-parse "a:b")
        up-b (default-parse "c:d")
        u-a1 (default-parse "a")
        u-a2 (default-parse "a")
        u-b (default-parse "c")]
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
