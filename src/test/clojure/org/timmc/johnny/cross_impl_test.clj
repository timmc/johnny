(ns org.timmc.johnny.cross-impl-test
  "This should be split up."
  (:require [clojure.test :refer :all]
            [org.timmc.johnny.util :as u]
            [org.timmc.johnny.impls :as i]
            [clojure.string :as str]))

(defmacro cross
  [binding-overlay & body]
  `((u/cross-thunk (merge i/url-impl-bindings ~binding-overlay)
                   #(do ~@body))))

(defmacro cross-all
  [& body]
  `(cross {} ~@body))

(comment ""
  (deftest minimality
    ;; TODO: Write test that builds a URL where each component is a string
    ;; containing all of lower ASCII (plus some non-ASCII Unicode) and then
    ;; check that the unencoded characters are appropriate.
    (cross-all
     (let [lunatech-example "http://example.com/:@-._~!$&'()*+,=;:@-._~!$&'()*+,=:@-._~!$&'()*+,==?/?:@-._~!$'()*+,;=/?:@-._~!$'()*+,;==#/?:@-._~!$&'()*+,;="]
       (is (= (.unparse (i/parse-u lunatech-example))
              lunatech-example))))))

(deftest differential-encoding
  (cross-all
   (testing "+ character"
     (let [orig "http://example.com/blue+light%20blue?k=blue%2Blight+blue"]
       (is (= (-> (i/parse-u orig) .getPath .getSegments)
              ["blue+light blue"]))
       (is (= (.queryGetLast (i/parse-u orig) "k") "blue+light+blue"))))))

(deftest workflow
  (cross-all
   (testing "README example"
     (let [u (-> (i/parse-u "http://example.net/search?q=1&q=2#fragment")
                 (.withHostRaw "brightcove.com")
                 (.querySetKey "q", "check"))]
       (is (= (str u)
              "http://brightcove.com/search?q=check#fragment"))))))

(deftest utf-8
  (cross-all
   (testing "Correctly encode/decode Unicode"
     (is (= (-> (i/parse-u "http://localhost")
                (.withFragment "ಠ")
                str/lower-case)
            "http://localhost#%e0%b2%a0"))
     (is (= (-> (.getFragment (i/parse-u "http://localhost#%e0%b2%a0")))
            "ಠ")))))
