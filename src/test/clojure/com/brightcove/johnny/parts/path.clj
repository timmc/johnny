(ns com.brightcove.johnny.parts.path
  "Tests for path parsing, manipulation, and encoding."
  (:require [clojure.test :refer :all])
  (:import com.brightcove.johnny.http.Urls
           (com.brightcove.johnny.parts TextPath)))

(deftest parsing
  (is (= (.getPathRaw (Urls/parse "http://google.com")) ""))
  (is (= (.getSegments (.getPath (Urls/parse "http://google.com"))) []))
  (let [parsed (Urls/parsePath "/.././/foo;page=1;sort=asc/;=&/_/../ba%2fr")]
    (is (= (.getSegments parsed)
           ["foo;page=1;sort=asc" ";=&" "ba/r"])))
  (is (thrown? NullPointerException
               (Urls/parsePath nil))))

(deftest regression-urlencode-spaces
  (let [path (.addSegments TextPath/EMPTY ["foo" "bar baz"])]
    (is (= (-> Urls/DEFAULT_CODECS
               (.pathEncoder)
               (.unparse (.getSegments path)))
           "/foo/bar%20baz"))))

(deftest integration
  (let [url (Urls/parse "http://[::1]/foo/bar")]
    (is (= (.unparse (.withPath url (-> (.getPath url)
                                        (.addRawPath "baz;a=b/quux")
                                        (.addOneSegment "/a?;"))))
           "http://[::1]/foo/bar/baz;a=b/quux/%2Fa%3F;"))))
