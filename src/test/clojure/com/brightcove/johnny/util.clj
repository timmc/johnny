(ns com.brightcove.johnny.util
  (:import (com.brightcove.johnny HttpUrls
                                  ImmutableHttpUrl
                                  MutableHttpUrl)))

(def known-impls #{MutableHttpUrl ImmutableHttpUrl})

(defn ^:internal get-parser
  [^Class impl]
  (.getMethod impl "from" (into-array Class [String])))

(defn ^:internal parse-via-impl
  [^String s, ^Class impl]
  (let [m (get-parser impl)]
    (.invoke m nil (to-array [s]))))

(def ^:dynamic *impl* nil)

(defn parse
  "Parse a string as a URL according to the current `*impl*`."
  [^String s]
  (parse-via-impl s *impl*))

(defn for-all-impls
  "Perform a thunk with each implementation successively."
  [thunk]
  (let [succeed (atom 0)
        current (atom nil)]
    (try
      (doseq [impl known-impls]
        (binding [*impl* impl]
          (reset! current impl)
          (thunk)
          (swap! succeed inc)))
      (finally
        (let [remaining (- (count known-impls) @succeed)]
          (when-not (zero? remaining)
            (binding [*out* *err*]
              (println "Failure for implementation:" (.getName @current))
              (println "Implementations skipped:" remaining))))))))
