(defproject com.brightcove/johnny "0.0.1-SNAPSHOT"
  :min-lein-version  "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.google.guava/guava "14.0.1"]]
  ;; Implementation is actually in Java
  :java-source-paths ["src/main/java" "src/test/java"]
  ;; Clojure is used for testing
  :source-paths []
  :test-paths ["src/test/clojure"]
  ;; We have a tiny bit of Java for testing
  :profiles {:dev {:dependencies [[junit/junit "4.12"]]}}
  :plugins [[lein-junit "1.1.8"]]
  :junit ["src/test/java"])
