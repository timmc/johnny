(ns com.brightcove.johnny.http.impls  
  (:import (com.brightcove.johnny.http
            Urls
            UrlParser JNUrlParser JNUriParser
            Url ImmutableUrl MutableUrl
            UrlEncoder))
  (:import (com.brightcove.johnny.parts
            NullableValueQueryParser NullIsEmptyQueryParser
            Query PersistentOrderedQuery
            MutableMultimapQuery PersistentMultimapQuery
            BasicQueryEncoder)))

;;;; Known implementations

(def url-parse-impls #{(JNUrlParser.) (JNUriParser.)})
(def url-manip-impls #{MutableUrl ImmutableUrl})
(def url-encode-impls #{(UrlEncoder.)})

(def q-parse-impls #{(NullableValueQueryParser.) (NullIsEmptyQueryParser.)})
(def q-manip-impls #{PersistentOrderedQuery MutableMultimapQuery
                     PersistentMultimapQuery})
(def q-encode-impls #{(BasicQueryEncoder.)})

(def default-url-parser Urls/STANDARD_URL_PARSER)
(def default-url-manip ImmutableUrl)
(def default-url-encode Urls/STANDARD_URL_ENCODER)

(def default-q-parser Urls/STANDARD_QUERY_PARSER)
(def default-q-manip PersistentOrderedQuery)
(def default-q-encode Urls/STANDARD_QUERY_ENCODER)

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)
(def ^:dynamic *url-manip* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-manip* nil)
(def ^:dynamic *query-encoder* nil)

;;;; Binding sets

(def url-impl-bindings
  {#'*url-parser* url-parse-impls
   #'*url-manip* url-manip-impls})

(def query-impl-bindings
  {#'*query-parser* q-parse-impls
   #'*query-manip* q-manip-impls
   #'*query-encoder* q-encode-impls})

;;;; Parsing

(defn ^:internal get-url-builder
  [^Class impl]
  {:pre [impl], :post [%]}
  (.getMethod impl "from" (into-array Class [String UrlParser])))

(defn parse-u
  "Parse a string as a URL according to the current impl."
  [^String s]
  (let [m (get-url-builder *url-manip*)]
    (try (.invoke m nil (to-array [s *url-parser*]))
         (catch java.lang.reflect.InvocationTargetException ite
           (throw (or (.getCause ite) ite))))))

(defn ^:internal get-query-constructor
  "Retrieve nullary constructor for Query implementation."
  [^Class impl]
  {:pre [impl], :post [%]}
  (.getConstructor impl (into-array Class [])))

(defn create-q
  "Construct a Query of the current impl."
  []
  (.newInstance (get-query-constructor *query-manip*) (to-array [])))

(defn parse-q
  "Parse a string as a Query."
  [^String s]
  (.appendAll (create-q) (.parse *query-parser* s)))
