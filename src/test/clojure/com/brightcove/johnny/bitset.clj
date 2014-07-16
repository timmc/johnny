(ns com.brightcove.johnny.bitset
  "Testing bitsets."
  (:require [clojure.test :refer :all]
            [org.timmc.handy.reflect :as rf]
            [clojure.test.check.generators :as gen]))

;;;; General

(defn inflate-methods
  "Convert shorthand method notation to full map form."
  [defaults method-shorthands]
  (for [m method-shorthands]
    (let [m (if (vector? m)
              {:call (first m), :params (vec (rest m))}
              m)]
      (merge defaults m))))

(comment
  "Source of method names."
  (->> (rf/methods java.util.BitSet)
       (filter #(and (not (:synthetic? %))
                     (not (:static? %))
                     (= (:visibility %) :public)))
       ((juxt filter remove) #(= (:return %) Void/TYPE))
       (map (partial map :name))))


;; The function calls for actions return pairs of [subject,
;; return]. The first element is to be used as the subject of the next
;; action; the second is the result of the action. These are different
;; when working with mutable objects. There are something like four
;; types of functions:
;;
;; - :accessor `[% (.accessor %)]` when querying the object
;; - :mutator `[% (do (.mutate %) _)]` when mutating the object and
;;     ignoring the result (builder pattern)
;; - :splitter `[% (.mutate %)]` when mutating the object and keeping
;;     the result
;; - :deriver `[(.derive %) _]` when the method call returns the new
;;     instance (or a reference to it)
;;
;; Based on these types + a knowledge of whether the particular type
;; exposes a mutation or persistence based interface, the actual
;; subject/return pattern can be inferred.

(defn apply-fn-group!
  "Apply [subject, return] fns and yield final {:subject, :return}
or {:throw}."
  [subject fn-group]
  (try
    (reduce (fn [{:keys [subject return]} f]
              ;; throws away intermediate :return values
              (zipmap [:subject :return]
                      (f subject)))
            {:subject subject :return nil}
            fn-group)
    (catch Throwable t
      {:throw (class t)})))

(defn apply-fn-groups!
  "Apply [subject, return] function groups to an object, yielding a
sequence of return values and possibly a terminal exception, one per
group (until throws.)"
  [subject fn-groups]
  (:results
   (reduce (fn [{:keys [subject done results] :as accum} fn-group]
             (if done
               accum
               (let [result (apply-fn-group! subject fn-group)]
                 (if (contains? result :throw)
                   {:done true
                    :results (conj results (select-keys result [:throw]))}
                   {:subject (:subject result)
                    :results (conj results (select-keys result [:return]))}))))
           {:subject subject, :results [], :done false}
           fn-groups)))

;;;; Bitset-specific

(def bitset-derivers
  (inflate-methods
   {:type :deriver}
   [[:clear]
    [:clear gen/nat]
    [:clear gen/nat gen/nat]
    [:set gen/nat]
    [:set gen/nat gen/boolean]
    [:set gen/nat gen/nat]
    [:set gen/nat gen/nat gen/boolean]
    [:flip gen/nat]
    [:flip gen/nat gen/nat]
    [:and ::bs]
    [:andNot ::bs]
    [:or ::bs]
    [:xor ::bs]]))

(def bitset-accessors
  (inflate-methods
   {:type :accessor}
   [[:get gen/nat]
    [:get gen/nat gen/nat]
    [:isEmpty]
    [:length]
    [:size]
    [:cardinality]
    [:intersects ::bs]
    [:nextClearBit gen/nat]
    [:nextSetBit gen/nat]
    [:previousClearBit (gen/fmap dec gen/nat)]
    [:previousSetBit (gen/fmap dec gen/nat)]
    {:call :toByteArray, :post seq}
    {:call :toLongArray, :post seq}]))

(def bitset-object-overrides
  (inflate-methods
   {}
   [{:call :equals, :params [::bs], :type :accessor}
    {:call :toString, :type :accessor}
    {:call :hashCode, :type :accessor}
    {:call :clone, :type :deriver}]))

(def bitset-methods
  (concat bitset-derivers bitset-accessors bitset-object-overrides))

