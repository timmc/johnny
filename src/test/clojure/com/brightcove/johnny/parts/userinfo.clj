(ns com.brightcove.johnny.parts.userinfo
  "Tests for userinfo parsing."
  (:require [clojure.test :refer :all])
  (:import com.brightcove.johnny.http.Urls
           (com.brightcove.johnny.parts UserInfo)))

(deftest parsing
  (let [parse (fn [raw] (let [ui (.parse Urls/DEFAULT_USERINFO_PARSER raw)]
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
                             (.unparse Urls/DEFAULT_USERINFO_ENCODER ui)))]
    (are [in out] (= (encode in) out)
         ["" nil] ""
         ["" ""] ":"
         ;; TODO Test for minimal encoding ["" ":::"] "::::"
         ["%" nil] "%25"
         ;; TODO more minimality tests ["ab:cd" "ef:gh:ij"] "ab%3Acd:ef:gh:ij"
         ["\u096e" "\u096f"] "%E0%A5%AE:%E0%A5%AF")))

(deftest object-overrides
  (let [up-a1 (.parse Urls/DEFAULT_USERINFO_PARSER "a:b")
        up-a2 (.parse Urls/DEFAULT_USERINFO_PARSER "a:b")
        up-b (.parse Urls/DEFAULT_USERINFO_PARSER "c:d")
        u-a1 (.parse Urls/DEFAULT_USERINFO_PARSER "a")
        u-a2 (.parse Urls/DEFAULT_USERINFO_PARSER "a")
        u-b (.parse Urls/DEFAULT_USERINFO_PARSER "c")]
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
