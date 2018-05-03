(ns org.timmc.johnny.authority
  "Tests for URiAuthority parsing."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls UriAuthority)
           (org.timmc.johnny.parts RegNameHost)))

(defn parse
  [s]
  (UriAuthority/parseGeneric s))

(deftest parsing
  (are [in out] (= (let [ua (try (UriAuthority/parseGeneric in)
                                 (catch Exception e :exc))]
                     [(.userinfoRaw ua) (.host ua) (.portRaw ua)])
                   out)
       "localhost" [nil (RegNameHost. "localhost") nil]))
