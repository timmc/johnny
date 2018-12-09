(def antlr-ver "4.7.1")

(defproject org.timmc/johnny "0.2.0-SNAPSHOT"
  :min-lein-version  "2.1.0" ;; 2.1.0 introduced jar classifiers
  :description "A URL parsing and manipulation library for the JVM emphasizing standards-compliance, flexibility, and ease of use."
  :url "https://github.com/timmc/johnny"
  :dependencies [[org.antlr/antlr4-runtime ~antlr-ver]]
  ;; Implementation is actually in Java, but most tests are written in
  ;; Clojure. There's one junit test in Java just to demonstrate
  ;; syntax.
  :source-paths []
  :test-paths ["src/test/clojure"]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.5.1"]
                                  [org.antlr/antlr4 ~antlr-ver]
                                  [org.jetbrains.kotlin/kotlin-stdlib "1.3.10"]]}}
  ;; TODO move sources/javadocs config to pom
  ;; Since we're deploying Java to Maven Central, we omit source from
  ;; the main jar and produce separate -sources and -javadoc jars.
  :omit-source true
  :classifiers
  {:sources
   {:java-source-paths ^:replace []
    :resource-paths ["src/main/java"]}
   :javadoc
   {:resource-paths ^:replace ["target/javadoc/javadoc"]
    :javadoc-opts
    {:package-names ["org.timmc.johnny"]
     :output-dir "target/javadoc/javadoc"
     :additional-args ["-version",
                       "-overview", "src/javadoc/overview.html",
                       "-charset", "UTF-8",
                       "-docencoding", "UTF-8", "-encoding", "UTF-8"]}
    :prep-tasks ["javadoc"]}}
  :deploy-repositories
  [["releases"
    {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
     :creds :gpg}]
   ["snapshots"
    {:url "https://oss.sonatype.org/content/repositories/snapshots/"
     :creds :gpg}]]
  :scm {:name "git" :url "git@github.com:timmc/johnny.git"}
  )
