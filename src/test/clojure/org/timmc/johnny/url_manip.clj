(ns org.timmc.johnny.url-manip
  "Tests for URL manipulation."
  (:require [clojure.test :refer :all]
            [org.timmc.johnny.util :as u]
            [org.timmc.johnny.impls :as i])
  (:import (org.timmc.johnny Urls MutableUrl)))

(defmacro cross
  [binding-overlay & body]
  `((u/cross-thunk (merge i/url-impl-bindings ~binding-overlay)
                   #(do ~@body))))

(deftest swap-single
  (cross
   {#'i/*url-parser* [i/default-url-parser]}
   (testing "Alter a single component at a time, checking that it works"
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
       (doseq [baseline [["http://" "user:pass@" "[::1%25eth0]" ":80"
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

(deftest chaining-optional
  (binding [i/*url-parser* i/default-url-parser
            i/*url-manip* MutableUrl]
    (let [make-orig (constantly (i/parse-u "http://brightcove.com"))]
      (is (= (str (doto (make-orig)
                    (.setHostRaw "localhost")
                    (.setFragment "frag")))
             (str (-> (make-orig)
                      (.withHostRaw "localhost")
                      (.withFragment "frag"))))))))

(deftest object-overrides
  (cross
   {#'i/*url-parser* [i/default-url-parser]}
   (let [ecom (i/parse-u "http://admin@example.com:80/path?query#frag")
         enet (i/parse-u "http://admin@example.net:80/path?query#frag")
         minimal (i/parse-u "http://localhost")]
     (testing "equals is at least string equality"
       (is (.equals ecom ecom))
       (is (not (.equals ecom enet))))
     (testing "equals can handle minimal URLs"
       (is (.equals minimal minimal)))
     (testing "hashcode is consistent"
       (is (= (.hashCode ecom) (.hashCode ecom)))))))
