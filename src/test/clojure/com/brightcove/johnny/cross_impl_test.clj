(ns com.brightcove.johnny.cross-impl-test
  "Examples drawn from:

* http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding"
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]))

(def getters
  [#(.getProtocol %) #(.getUserInfoRaw %) #(.getHost %) #(.getPort %)
   #(.getPathRaw %) #(.getQueryRaw %) #(.getFragment %)])

(def setters
  [#(.withProtocol % %2) #(.withUserInfoRaw % %2)
   #(.withHost % %2) #(.withPort % %2)
   #(.withPathRaw % %2) #(.withQueryRaw % %2) #(.withFragment % %2)])

(deftest parse
  (testing "raw http parts"
    (u/for-all-impls
     #(let [parts (u/parse "https://bob:bobby%2B@www.lunatech.com.:8080/file%2f;p%41=1%42?q%43=2%44#third%45")]
        (is (= ((apply juxt getters) parts)
               ["https" "bob:bobby%2B" "www.lunatech.com." 8080
                "/file%2f;p%41=1%42" "q%43=2%44" "third%45"])))))
  (testing "raw parts stay raw"
    (u/for-all-impls
     #(let [parts (u/parse "http://one%3Atwo:three@localhost/one%2Fpart?query%3f%26%3d")]
        (is (= (.getUserInfoRaw parts) "one%3Atwo:three"))
        (is (= (.getPathRaw parts) "/one%2Fpart"))
        (is (= (.getQueryRaw parts) "query%3f%26%3d")))))
  (testing "missing bits"
    (u/for-all-impls
     #(let [parts (u/parse "http://localhost")]
        (is (= ((apply juxt getters) parts)
               ["http" nil "localhost" nil
                "" nil nil]))))))

(deftest swap-single
  (u/for-all-impls
   #(testing "Alter a single component at a time"
      ;; List of component variations, each of which is a set of pairs of
      ;; value and serialized text (with delimiters).
      (let [variations [{"https" "https://", "http" "http://"}
                        {"to%3aen" "to%3aen@", nil nil, "" "@"}
                        {"timmc.local" "timmc.local"}
                        {nil "", 43 ":43"}
                        {"" "", "/" "/"}
                        {nil "", "" "?", "a=b?" "?a=b?"}
                        {nil "", "" "#", "foo#" "#foo%23"}]]
        ;; Set up a baseline URL, pre-decomposed into components plus
        ;; their delimiters
        (doseq [baseline [["http://" "user:pass@" "[::1%eth0]" ":80"
                           "/p/a/t/h/" "?q?u=er&&y" "#fragment"]
                          ["http://" nil "127.0.0.1" nil
                           nil nil nil]]
                :let [composed (apply str baseline)]]
          ;; For each component, try using the setter, and confirm that that
          ;; component is affected as expected
          (doseq [i (range 7)
                  :let [getter (get getters i)
                        setter (get setters i)]
                  [in out] (get variations i)]
            (let [altered (setter (u/parse composed) in)]
              ;; confirm that the set succeeds
              (is (= (getter altered) in))
              ;; confirm that the URL string representation changes correctly
              (is (= (str altered)
                     (apply str (assoc baseline i out)))))))))))

(deftest minimality
  ;; TODO: Write test that builds a URL where each component is a string
  ;; containing all of lower ASCII (plus some non-ASCII Unicode) and then
  ;; check that the unencoded characters are appropriate.
  (u/for-all-impls
   #(let [lunatech-example "http://example.com/:@-._~!$&'()*+,=;:@-._~!$&'()*+,=:@-._~!$&'()*+,==?/?:@-._~!$'()*+,;=/?:@-._~!$'()*+,;==#/?:@-._~!$&'()*+,;="]
      (is (= (.unparse (u/parse lunatech-example))
             lunatech-example)))))

(deftest j-n-url-regression
  (u/for-all-impls
   #(testing "port-numerics"
      (is (= (.getPort (u/parse "http://google.com:80/")) 80))
      ;; ८० is Devanagari numerals
      (is (thrown? java.net.MalformedURLException
                   (.getPort (u/parse "http://google.com:\u096E\u0966/")))))))

(deftest differential-encoding
  (u/for-all-impls
   #(testing "+ character"
      (let [orig "http://example.com/blue+light%20blue?blue%2Blight+blue"]
        ;; TODO: pending path and QS decoding
        ))))

(deftest workflow
  (u/for-all-impls
   #(testing "README example"
      (is (= (-> (u/parse "http://google.com/search?q=url#fragment")
                 (.withHost "brightcove.com")
                 (.addQueryParam "foo", "bar")
                 str)
             "http://brightcove.com/search?q=url&foo=bar#fragment")))))
