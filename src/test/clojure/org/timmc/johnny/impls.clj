(ns org.timmc.johnny.impls
  (:import (org.timmc.johnny
            Urls
            UrlParser AntlrUriParser SchemeSpecificUriParser
            Url ImmutableUrl))
  (:import (org.timmc.johnny.parts
            Host
            TextPathParser TextPath
            NullableValueQueryParser ImmutableOrderedParams
            PairQueryFormatter)))

;;;; Known implementations

;; Parsers are listed by instance, manipulation impls by class.

(def url-parse-impls #{(AntlrUriParser.) (SchemeSpecificUriParser.)})
(def url-manip-impls #{ImmutableUrl})

(def path-parse-impls #{(TextPathParser.)})
(def path-manip-impls #{TextPath})

(def q-parse-impls #{(NullableValueQueryParser.)})
(def q-manip-impls #{ImmutableOrderedParams})
(def q-format-impls #{(PairQueryFormatter.)})

;; The defaults manips are the empty instances, except for URL (which
;; does not yet support empty instances.)

(def default-url-parser Urls/urlParser)

(def default-path-parser Urls/pathParser)
(def default-path-inst Urls/emptyPath)

(def default-q-parser Urls/queryParser)
(def default-q-inst Urls/emptyParams)
(def default-q-format Urls/queryFormatter)

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)
(def ^:dynamic *url-manip* nil)

(def ^:dynamic *path-parser* nil)
(def ^:dynamic *path-manip* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-manip* nil)
(def ^:dynamic *query-formatter* nil)

;;;; Binding sets

(def url-impl-bindings
  {#'*url-parser* url-parse-impls
   #'*url-manip* url-manip-impls})

(def path-impl-bindings
  {#'*path-parser* path-parse-impls
   #'*path-manip* path-manip-impls})

(def query-impl-bindings
  {#'*query-parser* q-parse-impls
   #'*query-manip* q-manip-impls
   #'*query-formatter* q-format-impls})

;;;; Parsing

(def ^:internal url-rep-constructor-signature
  (into-array Class [String String Host String String String String]))

(defn parse-u
  "Parse a string as a URL according to the current impl."
  [^String s]
  (let [rep-class *url-manip*
        constr (.getConstructor rep-class url-rep-constructor-signature)
        parts (.parse *url-parser* s)]
    (try (.newInstance constr (to-array parts))
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
