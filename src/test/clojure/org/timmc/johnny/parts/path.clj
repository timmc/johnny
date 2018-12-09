(ns org.timmc.johnny.parts.path
  "Tests for path parsing, manipulation, and encoding."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls Paths TextPath)))

(deftest path-utils
  (are [i o] (= (Paths/explodeRaw i) o)
       "" []
       "/" [""]
       "//a" ["" "a"]
       "/a/b/c" ["a" "b" "c"]
       ".././a%2Fb/..b/c../.d/" [".." "." "a%2Fb" "..b" "c.." ".d" ""])
  (is (thrown-with-msg? IllegalArgumentException #"specified as non-null is null"
                        (Paths/explodeRaw nil)))
  (are [i o] (= (Paths/isAbsolute i) o)
       "" false
       "%2F" false
       "/" true
       "//" true
       "../../" false
       "a" false)
  (is (thrown-with-msg? IllegalArgumentException #"specified as non-null is null"
               (Paths/isAbsolute nil)))
  (let [trailing (.addRawPath (Paths/parse "/foo/bar/") "")]
    (is (.hasTrailingSlash trailing))
    (is (= (.format trailing) "/foo/bar/"))))

;; TODO: Test Paths, TextPath, and parsers and encoders

(deftest parsing
  (let [no-path (Urls/parse "https://example.com")]
    (is (= (.getPathRaw no-path) ""))
    (is (= (.getSegments (.getPath no-path)) []))
    (is (= (.hasTrailingSlash (.getPath no-path)) false)))
  (let [parsed (Urls/parsePath "/.././/foo;page=1;sort=asc/;=&/_/../ba%2fr")]
    (is (= (.getSegments parsed)
           ["foo;page=1;sort=asc" ";=&" "ba/r"])))
  (is (thrown? NullPointerException
               (Urls/parsePath nil))))

(deftest manipulation
  (is (= (.getSegments
          (.addSegments (Paths/from (into-array ["a" "b" ".." "c"]))
                        ["." "" "d" "e" ".."]))
         ["a" "c" "d"])))

(deftest regression-urlencode-spaces
  (let [path (.addSegments TextPath/EMPTY ["foo" "bar baz"])]
    (is (= (.format path)
           "/foo/bar%20baz"))))

(deftest integration
  (let [url (Urls/parse "http://[::1]/foo/bar")]
    (is (= (.format (.withPath url (-> (.getPath url)
                                       (.addRawPath "baz;a=b/quux")
                                        (.addOneSegment "/a?;"))))
           "http://[::1]/foo/bar/baz;a=b/quux/%2Fa%3F;"))))
