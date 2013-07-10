(ns com.brightcove.johnny.cross-impl-test
  "This should be split up."
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]
            [com.brightcove.johnny.http.impls :as i]
            [clojure.string :as str]))

(defmacro cross
  [& body]
  `(u/dorun-bindings
    (var i/*url-manip*) i/url-manip-impls
    #(u/dorun-bindings
      (var i/*url-parser*) i/url-parse-impls
      (fn tests [] ~@body))))

(deftest swap-single
  (cross
   (testing "Alter a single component at a time"
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
                 :let [getter (get u/url-getters i)
                       setter (get u/url-setters i)]
                 [in out] (get variations i)]
           (let [altered (setter (i/parse-u composed) in)]
             ;; confirm that the set succeeds
             (is (= (getter altered) in))
             ;; confirm that the URL string representation changes correctly
             (is (= (str altered)
                    (apply str (assoc baseline i out)))))))))))

(deftest minimality
  ;; TODO: Write test that builds a URL where each component is a string
  ;; containing all of lower ASCII (plus some non-ASCII Unicode) and then
  ;; check that the unencoded characters are appropriate.
  (cross
   (let [lunatech-example "http://example.com/:@-._~!$&'()*+,=;:@-._~!$&'()*+,=:@-._~!$&'()*+,==?/?:@-._~!$'()*+,;=/?:@-._~!$'()*+,;==#/?:@-._~!$&'()*+,;="]
     (is (= (.unparse (i/parse-u lunatech-example))
            lunatech-example)))))

(deftest j-n-url-regression
  (cross
   (testing "port-numerics"
     (is (= (.getPort (i/parse-u "http://google.com:80/")) 80))
     ;; ८० is Devanagari numerals
     (is (thrown? java.net.MalformedURLException
                  (.getPort (i/parse-u "http://google.com:\u096E\u0966/")))))))

(deftest differential-encoding
  (cross
   (testing "+ character"
     (let [orig "http://example.com/blue+light%20blue?blue%2Blight+blue"]
       ;; TODO: pending path and QS decoding
       ))))

(deftest workflow
  (cross
   (testing "README example"
     (let [u (-> (i/parse-u "http://example.net/search?q=1&q=2#fragment")
                 (.withHost "brightcove.com")
                 (.querySetKey "q", "check"))]
       (is (= (str u)
              "http://brightcove.com/search?q=check#fragment"))))))

(deftest utf-8
  (cross
   (testing "Correctly encode/decode Unicode"
     (is (= (-> (i/parse-u "http://localhost")
                (.withFragment "ಠ")
                str/lower-case)
            "http://localhost#%e0%b2%a0"))
     (is (= (-> (.getFragment (i/parse-u "http://localhost#%e0%b2%a0")))
            "ಠ")))))
