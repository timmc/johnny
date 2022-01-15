(def pom (slurp "pom.xml"))

(defn pom-version
  "Extract the version of a dependency specified in a pom.xml setting.
   Very hacky approach that parses XML with a small regex."
  [dep-name]
  (let [esc-name (java.util.regex.Pattern/quote dep-name)
        re (format "<%s.version>([^<]+)</%s.version>" esc-name esc-name)]
    (second (re-find (re-pattern re) pom))))

(defproject org.timmc/johnny "0.2.0-SNAPSHOT"
  :min-lein-version  "2.1.0" ;; 2.1.0 introduced jar classifiers
  :dependencies [[org.antlr/antlr4-runtime ~(pom-version "antlr")]]
  ;; Implementation is actually in Kotlin, but most tests are written in
  ;; Clojure.
  :source-paths []
  :test-paths ["src/test/clojure"]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.10.3"]
                                  [org.antlr/antlr4 ~(pom-version "antlr")]
                                  [org.jetbrains.kotlin/kotlin-stdlib ~(pom-version "kotlin")]
                                  ]}}
  )
