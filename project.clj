(def antlr-ver "4.7.1")

(defproject org.timmc/johnny "0.2.0-SNAPSHOT"
  :min-lein-version  "2.1.0" ;; 2.1.0 introduced jar classifiers
  :dependencies [[org.antlr/antlr4-runtime ~antlr-ver]]
  ;; Implementation is actually in Kotlin, but most tests are written in
  ;; Clojure.
  :source-paths []
  :test-paths ["src/test/clojure"]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.5.1"]
                                  [org.antlr/antlr4 ~antlr-ver]
                                  [org.jetbrains.kotlin/kotlin-stdlib "1.3.10"]]}}
  :deploy-repositories
  [["releases"
    {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
     :creds :gpg}]
   ["snapshots"
    {:url "https://oss.sonatype.org/content/repositories/snapshots/"
     :creds :gpg}]]
  )
