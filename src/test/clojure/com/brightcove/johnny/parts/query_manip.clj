(ns com.brightcove.johnny.parts.query-manip
  "Tests for query manipulation."
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]
            [com.brightcove.johnny.http.impls :as i])
  (:import (com.brightcove.johnny.coll MapEntry)
           (com.brightcove.johnny.http Urls)))

(defmacro cross
  [binding-overlay & body]
  `((u/cross-thunk (merge i/query-impl-bindings ~binding-overlay)
                   #(do ~@body))))

(defmacro cross-all
  [& body]
  `(cross {} ~@body))

(defn empty-not-nil?
  [coll]
  (and (empty? coll)
       (not (nil? coll))))

(deftest nil-raw
  (testing "Url-level q-parse defaults"
    (is (nil? (.getQuery (Urls/parse "http://localhost")))))
  (testing "Urls-level q-parse defaults"
    (is (nil? (Urls/parseQuery nil)))))

(deftest base-case
  (cross-all
   (doseq [raw ["" "&&&&&"]
           :let [qc #(i/parse-q raw)]] ;; there are mutable representations
     (testing (str "raw=" raw)
       (doseq [k [nil "foo"]]
         (testing (str "key=" k)
           (is (= (.hasKey (qc) k) false))
           (is (= (.getLast (qc) k) nil))
           (is (empty-not-nil? (.getAll (qc) k)))))
       (is (empty-not-nil? (.getPairs (qc))))
       (is (= (.countKeys (qc)) 0))
       (is (= (.countPairs (qc)) 0))))))

(deftest non-null-invariants
  (cross-all
   (doseq [raw [""
                "&&&&&"
                "a=%20%20%20&c=d"
                "a=&b=c=?&a=+++&b=%e2%98%83"]
           :let [qc #(i/parse-q raw) ;; there are mutable representations
                 orig (qc)]]
     (testing (str "raw=" (pr-str raw))
       (testing ".removeAll(k)"
         (let [val (.removeAll (qc) "a")]
           (is (not (.hasKey val "a")))
           (when-let [orig-a (seq (.getAll orig "a"))]
             (is (not (.hasPair val "a" (first orig-a)))))
           (is (nil? (.getLast val "a")))
           (is (empty-not-nil? (.getAll val "a")))
           (is (empty? (filter #(= (.getKey %) "a") (.getPairs val))))
           (is (= (- (.countKeys orig) (.countKeys val))
                  (if (.hasKey orig "a") 1 0)))
           (is (= (- (.countPairs orig) (.countPairs val))
                  (count (.getAll orig "a"))))))
       (testing ".removeAll(k,v)"
         (let [k "a"
               v "   "
               val (.removeAll (qc) k v)]
           (when (= (.getAll orig k) [v])
             (is (not (.hasKey val k)))
             (is (nil? (.getLast val k)))
             (is (= (- (.countKeys orig) (.countKeys val)) 1)))
           (is (not (.hasPair val k v)))
           (is (not (.contains (.getAll val k) v)))
           (is (not (.contains (.getPairs val)
                               (MapEntry. k v))))
           (is (= (- (.countPairs orig) (.countPairs val))
                  (if (.hasPair orig k v) 1 0)))))
       (testing ".append"
         (doseq [k [nil "foo" "a"] ;; at least one existing key
                 v [nil "" "bar"]] ;; at least one existing val for that key
           (testing (str "k=" (pr-str k) " v=" (pr-str v))
             (let [app (.append (qc) k v)]
               (is (= (.getLast app k) v))
               (is (.hasKey app k))
               (is (.contains (.getAll app k) v))
               (is (.contains (.getPairs app)
                              ;; use a Map.Entry with good equality semantics
                              (MapEntry. k v)))
               (is (= (- (.countKeys app) (.countKeys orig))
                      (if (.hasKey orig k) 0 1)))
               (is (= (- (.countPairs app) (.countPairs orig)) 1))))))
       (testing ".replaceLast"
         (let [change #(.replaceLast % "a" "new")
               repl (-> (qc) change)
               ;; check that replaceLast is idempotent
               idem (-> (qc) change change)]
           (doseq [[which val] {:replace-1 repl
                                :replace-2 idem}]
             (testing (str "which=" (name which))
               (is (.hasKey val "a"))
               (is (.hasPair val "a" "new"))
               (when (.implPreservesValueOrderPerKey val)
                 (is (= (.getLast val "a") "new")))
               (is (= (.contains (.getAll val "a") "new")))))))))))
