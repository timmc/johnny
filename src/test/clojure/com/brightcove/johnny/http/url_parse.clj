(ns com.brightcove.johnny.http.url-parse
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]
            [com.brightcove.johnny.http.impls :as i]
            [clojure.string :as str])
  (:import (com.brightcove.johnny.http ImmutableUrl)))

(defmacro cross
  [& body]
  `(binding [i/*url-manip* ImmutableUrl]
     (u/dorun-bindings (var i/*url-parser*) i/url-parse-impls
                       (fn tests [] ~@body))))

(deftest parse
  (cross
   (testing "Parse all parts"
     (let [parts (i/parse-u "https://bob:bobby%2B@www.lunatech.com.:8080/file%2f;p%41=1%42?q%43=2%44#third%45")]
       (is (= ((apply juxt u/url-getters) parts)
              ["https" "bob:bobby%2B" "www.lunatech.com." 8080
               "/file%2f;p%41=1%42" "q%43=2%44" "thirdE"]))))
   (testing "Raw parts stay raw: Don't decode delimiters"
     (let [parts (i/parse-u "http://one%3Atwo:three@localhost/one%2Fpart?query%3f%26%3d")]
       (is (= (.getUserInfoRaw parts) "one%3Atwo:three"))
       (is (= (.getPathRaw parts) "/one%2Fpart"))
       (is (= (.getQueryRaw parts) "query%3f%26%3d"))))
   (testing "Parse URL with max number of parts missing"
     (let [parts (i/parse-u "http://localhost")]
       (is (= ((apply juxt u/url-getters) parts)
              ["http" nil "localhost" nil
               "" nil nil]))))))
