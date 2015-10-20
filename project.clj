(defproject org.timmc/johnny "0.1.2-SNAPSHOT"
  :min-lein-version  "2.1.0" ;; 2.1.0 introduced jar classifiers
  :description "A URL parsing and manipulation library for the JVM emphasizing standards-compliance, flexibility, and ease of use."
  :url "https://github.com/timmc/johnny"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.google.guava/guava "14.0.1"]]
  :plugins [[lein-junit "1.1.8"]
            [lein-javadoc "0.2.1-SNAPSHOT"]]
  ;; Implementation is actually in Java, but most tests are written in
  ;; Clojure. There's one junit test in Java just to demonstrate
  ;; syntax.
  :java-source-paths ["src/main/java"]
  :source-paths []
  :test-paths ["src/test/clojure"]
  :javac-options ["-target" "1.7" "-source" "1.7"]
  :profiles {:dev {:dependencies [[junit/junit "4.12"]]
                   :java-source-paths ["src/test/java"]}}
  :junit ["src/test/java"]
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
     :additional-args ["-version" "-charset" "UTF-8"
                       "-docencoding" "UTF-8" "-encoding" "UTF-8"]}
    :prep-tasks ["javadoc"]}}
  :deploy-repositories
  [["releases"
    {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
     :creds :gpg}]
   ["snapshots"
    {:url "https://oss.sonatype.org/content/repositories/snapshots/"
     :creds :gpg}]]
  ;; Finally, metadata about the project: License, SCM link, developer
  ;; info. This is required by Sonatype OSS/Maven Central as part of
  ;; the generated POM file.
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}
  :scm {:name "git" :url "git@github.com:timmc/johnny.git"}
  :pom-addition
  [:developers
   [:developer
    [:name "Tim McCormack"]
    [:email "cortex@brainonfire.net"]
    [:url "https://www.brainonfire.net/"]]])
