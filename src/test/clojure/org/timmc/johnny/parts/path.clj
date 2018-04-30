(ns org.timmc.johnny.parts.path
  "Tests for path parsing, manipulation, and encoding."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls Paths)
           (org.timmc.johnny.parts TextPath)))

(deftest path-utils
  (are [i o] (= (Paths/explode i) o)
       "" []
       "/" [""]
       "//a" ["" "a"]
       "/a/b/c" ["a" "b" "c"]
       ".././a%2Fb/..b/c../.d/" [".." "." "a%2Fb" "..b" "c.." ".d" ""])
  (is (thrown? NullPointerException
               (Paths/explode nil)))
  (are [i o] (= (Paths/isAbsolute i) o)
       "" false
       "/" true
       "//" true
       "../../" false
       "a" false)
  (is (thrown? NullPointerException
               (Paths/isAbsolute nil)))
  (are [path abs back added] (= (let [effect (Paths/effectOf path)]
                                  [(.absolute effect)
                                   (.backwards effect)
                                   (.added effect)])
                                [abs back added])
       "" false 0 []))

;; TODO: Test Paths, TextPath, and parsers and encoders

(deftest parsing
  (is (= (.getPathRaw (Urls/parse "http://google.com")) ""))
  (is (= (.getSegments (.getPath (Urls/parse "http://google.com"))) []))
  (let [parsed (Urls/parsePath "/.././/foo;page=1;sort=asc/;=&/_/../ba%2fr")]
    (is (= (.getSegments parsed)
           ["foo;page=1;sort=asc" ";=&" "ba/r"])))
  (is (thrown? NullPointerException
               (Urls/parsePath nil))))

(deftest manipulation
  (is (= (.getSegments
          (.addSegments (TextPath. ["a" "b" ".." "c"])
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
