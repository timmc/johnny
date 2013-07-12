(ns com.brightcove.johnny.coll.multimap
  (:use clojure.test)
  (:import com.google.common.collect.ArrayListMultimap))
(.importClass *ns* 'PMM com.brightcove.johnny.coll.PersistentMultimap)

(deftest base-cases
  (testing "Properties of empty val"
    (let [e (PMM.)]
      (is (= (.size e) 0))
      (is (= (.length e) 0))
      (is (= (.isEmpty e) true))
      (doseq [k [nil "x"]]
        (is (= (.containsKey e k) false))
        (is (= (.get e k) [])))
      (doseq [v [nil "x"]]
        (is (= (.containsValue e v) false)))
      (doseq [k [nil "x"]
              v [nil "x"]]
        (is (= (.containsEntry e k v) false)))
      (is (= (.keySet e) #{}))
      (is (= (.size (.keys e)) 0))
      (is (= (.values e) []))
      (is (= (.entries e) []))
      (is (= (.asMap e) {})))))

(deftest ghost-keys
  (testing "Key is gone when values are gone"
    (let [single (.cons (PMM.) 1 2)]
      (is (.containsKey single 1))
      (doseq [[how rem] {"dissoc" (.dissoc single 1)
                   "dropLast" (.dropLast single 1 2)
                   "dropAll" (.dropAll single 1 2)
                   "assoc" (.assoc single 1 [])
                   "empty" (.empty single)}]
        (testing (str "after " how)
          (is (not (.containsKey rem 1))))))))

(deftest many-roads
  (testing "Several manipulations that should all produce the same result"
    (let [goal {"foo" ["bar" "bar" "baz"] "quux" ["grovel" nil]}
          consing #(-> %
                       (.cons "foo" "bar")
                       (.cons "quux" "grovel")
                       (.cons "foo" "bar")
                       (.cons "foo" "baz")
                       (.cons "quux" nil))
          assoc-per-key #(-> %
                             (.assoc "quux" ["grovel" nil])
                             (.assoc "foo" ["bar" "bar" "baz"]))
          cons-entries #(.consAll %
                                  ^java.util.Iterable
                                  (for [[k vs] goal
                                        v vs]
                                    (first {k v})))
          cons-kvs #(reduce (fn [m [k vs]] (.consAll m k vs)) % goal)
          cons-mm #(let [mm (ArrayListMultimap/create)]
                     (doseq [[k vs] goal]
                       (.putAll mm k vs))
                     (.consAll % mm))
          paths {:consing (consing (PMM.))
                 :assoc-per-key (assoc-per-key (PMM.))
                 :cons-entries (cons-entries (PMM.))
                 :cons-kvs (cons-kvs (PMM.))
                 :cons-mm (cons-mm (PMM.))
                 :drop-and-add-after (-> (consing (PMM.))
                                         (.dropLast "quux" "grovel")
                                         (.cons "quux" "grovel")
                                         (.dropAll "quux" nil)
                                         (.cons "quux" nil))
                 :tmp-spurious (-> (cons-entries (PMM.))
                                   (.cons "1" "2")
                                   (.dissoc "1"))
                 :empty (-> (.cons (PMM.) "3" "4")
                            (.empty)
                            cons-mm)
                 :drop-val-sandwich (-> (PMM.)
                                        (.cons "quux" "spurious")
                                        assoc-per-key
                                        (.dropLast "quux" "spurious"))}
          checkers {:asmap #(is (= (into {} (for [[k vs] (.asMap %)]
                                              [k (vec vs)]))
                                   goal))
                    :keys #(is (= (sort (seq (.keys %)))
                                  (sort (for [k (keys goal)
                                              _ (goal k)]
                                          k))))
                    :keySet #(is (= (set (keys goal)) (.keySet %)))
                    :size #(is (= (.size %) 5))
                    :not-empty #(is (not (.isEmpty %)))
                    :length #(is (= (.length %) 2))
                    :contains-goal-kv #(doseq [[gk gvs] goal
                                               gv gvs]
                                         (is (.containsEntry % gk gv)))
                    :contains-goal-key #(doseq [gk (keys goal)]
                                          (is (.containsKey % gk)))
                    :contains-goal-val #(doseq [gv (apply concat (vals goal))]
                                          (is (.containsValue % gv)))
                    :entries #(doseq [e (.entries %)]
                                (is (.contains (goal (key e)) (val e))))
                    :get #(doseq [[k vs] goal]
                            (is (= (.get % k) vs)))
                    :no-empty-keys #(doseq [k (.keySet %)]
                                      (is (not-empty (.get % k))))}]
      (doseq [[path val] paths]
        (testing (str "path=" (name path))
          (doseq [[ch-n ch-v] checkers]
            (testing (str "checker=" (name ch-n))
              (ch-v val))))))))
