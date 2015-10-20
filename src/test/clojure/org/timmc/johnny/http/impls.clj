(ns org.timmc.johnny.http.impls  
  (:import (org.timmc.johnny.http
            Urls
            UrlParser JNUrlParser JNUriParser SchemeSpecificUriParser
            Url ImmutableUrl MutableUrl
            UrlEncoder))
  (:import (org.timmc.johnny.parts
            TextPathParser TextPath TextPathEncoder
            NullableValueQueryParser NullIsEmptyQueryParser
            PersistentOrderedParams MutableMultimapParams
            PersistentMultimapParams ImmutableOrderedParams
            BasicQueryEncoder)))

;;;; Known implementations

;; Parsers are listed by instance, manipulation impls by class.

(def url-parse-impls #{(JNUrlParser.) (JNUriParser.)
                       (SchemeSpecificUriParser.)})
(def url-manip-impls #{MutableUrl ImmutableUrl})
(def url-encode-impls #{(UrlEncoder.)})

(def path-parse-impls #{(TextPathParser.)})
(def path-manip-impls #{TextPath})
(def path-encode-impls #{(TextPathEncoder.)})

(def q-parse-impls #{(NullableValueQueryParser.) (NullIsEmptyQueryParser.)})
(def q-manip-impls #{PersistentOrderedParams MutableMultimapParams
                     PersistentMultimapParams ImmutableOrderedParams})
(def q-encode-impls #{(BasicQueryEncoder.)})

;; The defaults manips are the empty instances, except for URL (which
;; does not yet support empty instances.)

(def default-url-parser (.urlParser Urls/DEFAULT_CODECS))
(def default-url-manip (.urlRepresentation Urls/DEFAULT_CODECS))
(def default-url-encode (.urlEncoder Urls/DEFAULT_CODECS))

(def default-path-parser (.pathParser Urls/DEFAULT_CODECS))
(def default-path-inst (.emptyPath Urls/DEFAULT_CODECS))
(def default-path-encode (.pathEncoder Urls/DEFAULT_CODECS))

(def default-q-parser (.queryParser Urls/DEFAULT_CODECS))
(def default-q-inst (.emptyParams Urls/DEFAULT_CODECS))
(def default-q-encode (.queryEncoder Urls/DEFAULT_CODECS))

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
  (.addSegments (create-p) (.parse *path-parser* s)))

(defn create-q
  "Construct a Query of the current impl."
  []
  (get-empty-instance *query-manip*))

(defn parse-q
  "Parse a string as a Query."
  [^String s]
  (.appendAll (create-q) (.parse *query-parser* s)))
