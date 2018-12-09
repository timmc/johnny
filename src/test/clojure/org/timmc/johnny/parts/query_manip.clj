(ns org.timmc.johnny.parts.query-manip
  "Tests for query manipulation."
  (:require [clojure.test :refer :all]
            [org.timmc.johnny.util :as u]
            [org.timmc.johnny.impls :as i])
  (:import (org.timmc.johnny Urls)
           (org.timmc.johnny.internal.coll MapEntry)))
(.importClass *ns* 'ME org.timmc.johnny.internal.coll.MapEntry)

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

;; TODO add tests for + vs. %20

(deftest non-null-invariants

  (cross-all
   ;; Appending to various non-empty queries
   (let [base (i/parse-q "m=5&m=6")]
     (let [appended (.. base
                        (append "m" "6") ;; again
                        (append "a" "before")
                        (append "m" "7")
                        (append "z" "after"))]
       (is (= (sort (.getAll appended "m")) ["5" "6" "6" "7"]))
       (is (= (.getLast appended "m") "7"))
       (let [final (last (.getPairs appended))]
         (is (= (key final) "z"))
         (is (= (val final) "after")))))
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
         (doseq [k ["foo" "a"]
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
         (doseq [k ["foo" "a"] ;; at least one existing key
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
               (doseq [[k v] data]
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
               (is (= (.getLast val "a") "new"))
               (is (= (.contains (.getAll val "a") "new")))))))))))
