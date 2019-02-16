(ns org.timmc.johnny.impls
  (:import (org.timmc.johnny Host Queries)
           (org.timmc.johnny.internal
            SchemeSpecificUriParser
            NullableValueQueryParser ImmutableOrderedParams
            PairQueryFormatter AntlrUriParser)))

;;;; Known implementations

;; Parsers are listed by instance, manipulation impls by class.

(def url-parse-impls #{(AntlrUriParser.) (SchemeSpecificUriParser.)})

(def q-parse-impls #{(NullableValueQueryParser.)})
(def q-manip-impls #{ImmutableOrderedParams})
(def q-format-impls #{(PairQueryFormatter.)})

;; The defaults manips are the empty instances, except for URL (which
;; does not yet support empty instances.)

(def default-url-parser (AntlrUriParser.))

;;;; Bindings for current preferred implementation

(def ^:dynamic *url-parser* nil)

(def ^:dynamic *path-parser* nil)
(def ^:dynamic *path-manip* nil)

(def ^:dynamic *query-parser* nil)
(def ^:dynamic *query-formatter* nil)

;;;; Binding sets

(def url-impl-bindings
  {#'*url-parser* url-parse-impls})

(def query-impl-bindings
  {#'*query-parser* q-parse-impls
   #'*query-formatter* q-format-impls})

;;;; Parsing

(def ^:internal url-rep-constructor-signature
  (into-array Class [String String Host String String String String]))

(defn parse-u
  "Parse a string as a URL according to the current impl."
  [^String s]
  (.parseHostedUri *url-parser* s))

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

(defn parse-q
  "Parse a string as a Query."
  [^String s]
  (Queries/parse s))
