(defproject org.timmc/johnny "0.1.1"
  :min-lein-version  "2.5.1" ;; for classified jars
  :description "A URL parsing and manipulation library for the JVM emphasizing standards-compliance, flexibility, and ease of use."
  :url "https://github.com/timmc/johnny"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.google.guava/guava "14.0.1"]]
  ;; Implementation is actually in Java
  :java-source-paths ["src/main/java"]
  ;; Clojure is used for testing
  :source-paths []
  :test-paths ["src/test/clojure"]
  ;; We have a tiny bit of Java for testing
  :profiles {:dev {:dependencies [[junit/junit "4.12"]]
                   :java-source-paths ["src/test/java"]}}
  :plugins [[lein-junit "1.1.8"]
            [org.clojars.brightcove/lein-javadoc "0.2.0"]]
  :junit ["src/test/java"]
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
     :additional-args ["-Xdoclint:-missing" "-version" "-charset" "UTF-8"
                       "-docencoding" "UTF-8" "-encoding" "UTF-8"]}
    :prep-tasks ["javadoc"]}}
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}
  :scm {:name "git" :url "git@github.com:timmc/johnny.git"}
  :pom-addition
  [:developers
   [:developer
    [:name "Tim McCormack"]
    [:url "https://www.brainonfire.net/"]
    [:organization "Brightcove Inc."]
    [:organizationUrl "https://www.brightcove.com/"]]]
  :deploy-repositories
  [["releases"
    {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
     :creds :gpg}]
   ["snapshots"
    {:url "https://oss.sonatype.org/content/repositories/snapshots/"
     :creds :gpg}]])
