(ns com.brightcove.johnny.util
  "Utilities for testing."
  (:require [clojure.test :as test]))

(def url-getters
  "In order, the getters on http.Url."
  [#(.getScheme %) #(.getUserInfoRaw %) #(.getHostRaw %) #(.getPort %)
   #(.getPathRaw %) #(.getQueryRaw %) #(.getFragment %)])

(def url-setters
  "In order, the chaining 'setters' on http.Url."
  [#(.withScheme % %2) #(.withUserInfoRaw % %2)
   #(.withHostRaw % %2) #(.withPort % (and %2 (int %2)))
   #(.withPathRaw % %2) #(.withQueryRaw % %2) #(.withFragment % %2)])

(defn dorun-bindings
  "Perform a thunk under a series of bindings for a var."
  [the-var vals thunk]
  (let [succeed (atom 0)
        current (atom nil)]
    (try
      (doseq [val vals]
        ;; binding is a macro so you can't pass in a var
        (try (push-thread-bindings {the-var val})
             (reset! current val)
             (test/testing (str the-var " bound to " val "\n")
               (thunk))
             (swap! succeed inc)
             nil
             (finally (pop-thread-bindings))))
      (finally ;; Detect exceptions and note early bail-out
        (let [unfinished (- (count vals) @succeed)]
          (when (< 0 unfinished)
            (println "Threw on val:" @current)
            (when (< 1 unfinished)
              (println "Vals skipped:" (dec unfinished)))))))))

(defn cross-thunk
  "Wrap a thunk in a dorun-bindings for each var-vals pair in bindings.
Yields a thunk that will run the input thunk once for every combination
of bindings."
  [bindings thunk]
  (reduce (fn [acc [a-var some-vals]]
            #(dorun-bindings a-var some-vals acc))
          thunk
          bindings))
