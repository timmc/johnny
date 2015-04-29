(defproject org.timmc/johnny "0.1.0-SNAPSHOT"
  :min-lein-version  "2.0.0"
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
  :plugins [[lein-junit "1.1.8"]]
  :junit ["src/test/java"]
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
  [["releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                :creds :gpg}
    "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                 :creds :gpg}]])
