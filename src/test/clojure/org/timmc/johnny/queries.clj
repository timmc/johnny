(ns org.timmc.johnny.queries
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Queries)))

(defn params-seq
  [p]
  (map (juxt key val) (.getPairs p)))

(deftest factories
  (is (= (.getPairs (Queries/empty)) []))
  (is (= (params-seq (Queries/from "k" "v"))
         [["k" "v"]]))
  (is (= (params-seq (Queries/from "k" ["1" "2" "3"]))
         [["k" "1"] ["k" "2"] ["k" "3"]]))
  (is (= (params-seq (Queries/from {"k1" "v1", "k2" "v2"}))
         [["k1" "v1"] ["k2" "v2"]])))

(deftest formatting
  (is (= (Queries/formatQuery (Queries/empty)) ""))
  (is (= (-> (Queries/from "k" "v")
             (.append "no" nil)
             Queries/formatQuery)
         "k=v&no")))
