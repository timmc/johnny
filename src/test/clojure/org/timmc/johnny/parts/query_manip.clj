(ns org.timmc.johnny.parts.query-manip
  "Tests for query manipulation."
  (:require [clojure.test :refer :all]
            [org.timmc.johnny.util :as u]
            [org.timmc.johnny.impls :as i])
  (:import (org.timmc.johnny.coll MapEntry)
           (org.timmc.johnny Urls)))
(.importClass *ns* 'ME org.timmc.johnny.coll.MapEntry)

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

(deftest construction
  (cross
   {#'i/*query-formatter* [nil]}
   (let [val (i/parse-q "a=5&b=&a=6")]
     (is (= (.countKeys val) 2))
     (is (.hasKey val "a"))
     (is (.hasKey val "b"))
     (if (.implPreservesRepeatedKeys val)
       (do (is (= (.countPairs val) 3))
           (when (.implPreservesValueOrderPerKey val)
             (is (= (.getLast val "a") "6"))
             (is (= (.getLast val "b") ""))
             (is (= (.getAll val "a") ["5" "6"])))
           (let [ordered [(ME. "a" "5") (ME. "b" "") (ME. "a" "6")]]
             (if (.implPreservesPairOrder val)
               (is (= (.getPairs val) ordered))
               (is (= (set (.getPairs val)) (set ordered))))))
       (do (is (= (.countPairs val) 2))
           (is (= (set (map first (.getPairs val))) #{"a" "b"})))))))

(deftest non-null-invariants
  ;; Detailed tests of .appendAll first
  (cross
   {#'i/*query-parser* [nil]
    #'i/*query-formatter* [nil]}
   ;; Empty
   (doseq [[which val] {:fresh (i/create-q)
                        :append-nothing (.appendAll (i/create-q) [])}]
     (testing which
       (is (zero? (.countKeys val)))
       (is (zero? (.countPairs val)))
       (is (empty-not-nil? (.getPairs val)))
       (doseq [k [nil "" "foo"]]
         (testing (str "k=" (pr-str k))
           (is (not (.hasKey val k)))
           (is (nil? (.getLast val k)))
           (is (empty-not-nil? (.getAll val k)))
           (doseq [v [nil "" "bar"]]
             (testing (str "v=" (pr-str v))
               (is (not (.hasPair val k v))))))))))
  (cross-all
   ;; Appending to various non-empty queries
   (let [base (i/parse-q "m=5&m=6")]
     (let [appended (.. base
                        (append "m" "6") ;; again
                        (append "a" "before")
                        (append "m" "7")
                        (append "z" "after"))]
       (if (.implPreservesRepeatedKeys base)
         (is (= (sort (.getAll appended "m")) ["5" "6" "6" "7"]))
         (is (.contains (.getAll appended "m") "7")))
       (when (.implPreservesValueOrderPerKey base)
         (is (= (.getLast appended "m") "7")))
       (when (.implPreservesPairOrder base)
         (let [final (last (.getPairs appended))]
           (is (= (key final) "z"))
           (is (= (val final) "after"))))))
   ;; Now test things based on .appendAll
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
         (doseq [k [nil "foo" "a"]
                 v [nil "   " "bar"]
                 :let [val (.removeAll (qc) k v)]]
           (testing (str "k=" (pr-str k) " v=" (pr-str v))
             (when (= (.getAll orig k) [v])
               (is (not (.hasKey val k)))
               (is (nil? (.getLast val k)))
               (is (= (- (.countKeys orig) (.countKeys val)) 1)))
             (is (not (.hasPair val k v)))
             (is (not (.contains (.getAll val k) v)))
             (is (not (.contains (.getPairs val)
                                 (MapEntry. k v))))
             (is (= (- (.countPairs orig) (.countPairs val))
                    (if (.hasPair orig k v) 1 0))))))
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
       (testing ".appendAll"
         (doseq [[which data] {:empty []
                               :overlaps (concat {"a" "new"} {"b" "c=?"}
                                                 {"a" "nuovo"} {"" ""})}
                 :let [last-vals (into {} data)]]
           (testing (str which)
             (let [val (.appendAll (qc) data)]
               (doseq [[k v] (if (.implPreservesRepeatedKeys val)
                               data
                               last-vals)]
                 (is (.hasPair val k v)))))))
       (testing ".replace"
         (let [change #(.replace % "a" "new")
               repl (-> (qc) change)
               ;; check that replace is idempotent
               idem (-> (qc) change change)]
           (doseq [[which val] {:replace-1 repl
                                :replace-2 idem}]
             (testing (str "which=" (name which))
               (is (.hasKey val "a"))
               (is (.hasPair val "a" "new"))
               (is (= (.getLast val "a") "new"))
               (is (= (vec (.getAll val "a")) ["new"]))))))
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
