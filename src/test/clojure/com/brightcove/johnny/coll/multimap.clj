(ns com.brightcove.johnny.coll.multimap
  (:use clojure.test))
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
    (let [goal {"foo" ["bar" "bar" "baz"] "quux" ["grovel"]}
          paths {:consing (-> (PMM.)
                              (.cons "foo" "bar")
                              (.cons "quux" "grovel")
                              (.cons "foo" "bar")
                              (.cons "foo" "baz"))}
          checkers {:asmap #(is (= (into {} (for [[k vs] (.asMap %)]
                                              [k (vec vs)]))
                                   goal))}]
      (doseq [[path val] paths]
        (testing (str "path=" (name path))
          (is (= (.size val) 4))
          (is (= (.length val) 2))
          (doseq [[ch-n ch-v] checkers]
            (testing (str "checker=" (name ch-n))
              (ch-v val))))))))
