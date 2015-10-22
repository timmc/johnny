(ns org.timmc.johnny.authority
  "Tests for URiAuthority parsing."
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny Urls UriAuthority)))

(defn parse
  [s]
  (UriAuthority/parseGeneric s))

(deftest parsing
  (are [in out] (= (let [ua (try (UriAuthority/parseGeneric in)
                                 (catch Exception e :exc))]
                     [(.userinfoRaw ua) (.hostRaw ua) (.portRaw ua)])
                   out)
       "localhost" [nil "localhost" nil]))
