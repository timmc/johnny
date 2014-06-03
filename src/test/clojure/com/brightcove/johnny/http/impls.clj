(ns com.brightcove.johnny.http.impls  
  (:import (com.brightcove.johnny.http
            Urls
            UrlParser JNUrlParser JNUriParser
            Url ImmutableUrl MutableUrl
            UrlEncoder))
  (:import (com.brightcove.johnny.parts
            StdPathParser StdPath PathEncoder
            NullableValueQueryParser NullIsEmptyQueryParser
            PersistentOrderedParams MutableMultimapParams
            PersistentMultimapParams
            BasicQueryEncoder)))

;;;; Known implementations

;; Parsers are listed by instance, manipulation impls by class.

(def url-parse-impls #{(JNUrlParser.) (JNUriParser.)})
(def url-manip-impls #{MutableUrl ImmutableUrl})
(def url-encode-impls #{(UrlEncoder.)})

(def path-parse-impls #{(StdPathParser.)})
(def path-manip-impls #{StdPath})
(def path-encode-impls #{(PathEncoder.)})

(def q-parse-impls #{(NullableValueQueryParser.) (NullIsEmptyQueryParser.)})
(def q-manip-impls #{PersistentOrderedParams MutableMultimapParams
                     PersistentMultimapParams})
(def q-encode-impls #{(BasicQueryEncoder.)})

;; The defaults manips are the empty instances, except for URL (which
;; does not yet support empty instances.)

(def default-url-parser Urls/DEFAULT_URL_PARSER)
(def default-url-manip ImmutableUrl)
(def default-url-encode Urls/DEFAULT_URL_ENCODER)

(def default-path-parser Urls/DEFAULT_PATH_PARSER)
(def default-path-inst Urls/DEFAULT_EMPTY_PATH)
(def default-path-encode Urls/DEFAULT_PATH_ENCODER)

(def default-q-parser Urls/DEFAULT_QUERY_PARSER)
(def default-q-inst Urls/DEFAULT_EMPTY_PARAMS)
(def default-q-encode Urls/DEFAULT_QUERY_ENCODER)

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)
(def ^:dynamic *url-manip* nil)

(def ^:dynamic *path-parser* nil)
(def ^:dynamic *path-manip* nil)
(def ^:dynamic *path-encoder* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-manip* nil)
(def ^:dynamic *query-encoder* nil)

;;;; Binding sets

(def url-impl-bindings
  {#'*url-parser* url-parse-impls
   #'*url-manip* url-manip-impls})

(def path-impl-bindings
  {#'*path-parser* path-parse-impls
   #'*path-manip* path-manip-impls
   #'*path-encoder* path-encode-impls})

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

(defn ^:internal get-nullary-constructor
  [^Class impl]
  {:pre [impl], :post [%]}
  (.getConstructor impl (into-array Class [])))

(defn ^:internal get-empty-instance
  [^Class impl]
  (.newInstance (get-nullary-constructor impl) (to-array [])))

(defn create-p
  "Construct a Path of the current impl."
  []
  (get-empty-instance *path-manip*))

(defn parse-p
  "Parse a string as a Path."
  [^String s]
  (.appendAll (create-p) (.parse *path-parser* s)))


(defn create-q
  "Construct a Query of the current impl."
  []
  (get-empty-instance *query-manip*))

(defn parse-q
  "Parse a string as a Query."
  [^String s]
  (.appendAll (create-q) (.parse *query-parser* s)))
