(ns com.brightcove.johnny.http.impls  
  (:import (com.brightcove.johnny.http
            Urls
            UrlParser JNUrlParser JNUriParser
            Url ImmutableUrl MutableUrl
            NullableValueQueryParser NullIsEmptyQueryParser
            BasicQueryEncoder))
  (:import (com.brightcove.johnny.parts
            Query PersistentOrderedQuery
            MutableMultimapQuery PersistentMultimapQuery)))

;;;; Known implementations

(def url-parse-impls #{(JNUrlParser.) (JNUriParser.)})
(def url-manip-impls #{MutableUrl ImmutableUrl})
(def q-parse-impls #{NullableValueQueryParser NullIsEmptyQueryParser})
(def q-manip-impls #{PersistentOrderedQuery})
(def q-encode-impls #{(BasicQueryEncoder.)})

(def default-url-parser Urls/STANDARD_URL_PARSER)
(def default-url-manip ImmutableUrl)

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)
(def ^:dynamic *url-manip* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-manip* nil)
(def ^:dynamic *query-encoder* nil)

;;;; Binding sets

(def url-impl-bindings
  {#'*url-manip* url-manip-impls
   #'*url-parser* url-parse-impls})

;;;; Parsing

(defn ^:internal get-bits-builder
  [^Class impl]
  {:pre [impl], :post [impl]}
  (.getMethod impl "from" (into-array Class [String UrlParser])))

(defn parse-u
  "Parse a string as a URL according to the current impl."
  [^String s]
  (let [m (get-bits-builder *url-manip*)]
    (try (.invoke m nil (to-array [s *url-parser*]))
         (catch java.lang.reflect.InvocationTargetException ite
           (throw (or (.getCause ite) ite))))))
