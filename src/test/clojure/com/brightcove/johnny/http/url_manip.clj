(ns com.brightcove.johnny.http.url-manip
  "Tests for URL manipulation."
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]
            [com.brightcove.johnny.http.impls :as i])
  (:import (com.brightcove.johnny.http Urls MutableUrl)))

(deftest chaining-optional
  (binding [i/*url-parser* i/default-url-parser
            i/*url-manip* MutableUrl]
    (let [make-orig (constantly (i/parse-u "http://brightcove.com"))]
      (is (= (str (doto (make-orig)
                    (.setHost "localhost")
                    (.setFragment "frag")))
             (str (-> (make-orig)
                      (.withHost "localhost")
                      (.withFragment "frag"))))))))
