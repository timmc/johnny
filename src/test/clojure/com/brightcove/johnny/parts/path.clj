(ns com.brightcove.johnny.parts.path
  "Tests for path parsing, manipulation, and encoding."
  (:require [clojure.test :refer :all])
  (:import com.brightcove.johnny.http.Urls))

(deftest parsing
  (let [parsed (Urls/parsePath "/foo;page=1;sort=asc/;=&//ba%2fr")
        segs (.getSegments parsed)]
    (is (= (count segs) 4))
    (is (= (-> segs (nth 0) (.text)) "foo"))
    (is (= (-> segs (nth 0) (.params) (.countKeys)) 2))
    (is (= (-> segs (nth 0) (.params) (.getLast "page")) "1"))
    (is (= (-> segs (nth 1) (.params) (.getLast "")) "&"))
    (is (= (-> segs (nth 2) (.text)) ""))
    (is (= (-> segs (nth 2) (.params) (.countPairs)) 0))
    (is (= (-> segs (nth 3) (.text)) "ba/r"))))

(deftest integration
  (let [url (Urls/parse "http://[::1]/foo/bar")]
    (is (= (.unparse (.withPath url (-> (.getPath url)
                                        (.addRawPath "baz;a=b/quux")
                                        (.addOneSegment "/a?;"))))
           "http://[::1]/foo/bar/baz;a=b/quux/%2Fa%3F%3B"))))
