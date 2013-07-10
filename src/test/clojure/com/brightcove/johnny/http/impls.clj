(ns com.brightcove.johnny.http.impls  
  (:import (com.brightcove.johnny.http
            UrlParser JNUrlParser
            Url ImmutableUrl MutableUrl
            BasicQueryEncoder)))

;;;; Known implementations

(def url-parse-impls #{(JNUrlParser.)})
(def url-manip-impls #{MutableUrl ImmutableUrl})
(def q-encode-impls #{(BasicQueryEncoder.)})

(def default-url-parser (JNUrlParser.))

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)
(def ^:dynamic *url-manip* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-manip* nil)
(def ^:dynamic *query-encoder* nil)

;;;; Parsing

(defn ^:internal get-bits-builder
  [^Class impl]
  {:pre [impl], :post [impl]}
  (.getMethod impl "from" (into-array Class [String UrlParser])))

(defn parse-u
  "Parse a string as a URL according to the current impl."
  [^String s]
  (let [m (get-bits-builder *url-manip*)]
    (.invoke m nil (to-array [s *url-parser*]))))
