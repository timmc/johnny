(ns com.brightcove.johnny.cross-impl-test
  (:require [clojure.test :refer :all]
            [com.brightcove.johnny.util :as u]))

(deftest parts
  (u/for-all-impls
   #(let [parts (u/parse "https://bob:bobby%2B@www.lunatech.com.:8080/file%2f;p%41=1%42?q%43=2%44#third%45")]
      (is (= (.getProtocol parts) "https"))
      (is (= (.getUserInfo parts) "bob:bobby%2B"))
      (is (= (.getHost parts) "www.lunatech.com."))
      (is (= (.getPort parts) 8080))
      (is (= (.getPathRaw parts) "/file%2f;p%41=1%42"))
      (is (= (.getQueryRaw parts) "q%43=2%44"))
      (is (= (.getFragment parts) "third%45")))))

;; http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding
(deftest minimality
  (u/for-all-impls
   #(let [lunatech-example "http://example.com/:@-._~!$&'()*+,=;:@-._~!$&'()*+,=:@-._~!$&'()*+,==?/?:@-._~!$'()*+,;=/?:@-._~!$'()*+,;==#/?:@-._~!$&'()*+,;="]
      (is (= (.unparse (u/parse lunatech-example))
             lunatech-example)))))

(deftest j-n-url-regression
  (u/for-all-impls
   #(testing "port-numerics"
      (is (= (.getPort (u/parse "http://google.com:80/")) 80))
      ;; ८० is Devanagari numerals
      (is (thrown? java.net.MalformedURLException
                   (.getPort (u/parse "http://google.com:\u096E\u0966/")))))))

(deftest differential-encoding
  (u/for-all-impls
   #(testing "+ character"
      (let [orig "http://example.com/blue+light%20blue?blue%2Blight+blue"]
        ;; TODO: pending path and QS decoding
        ))))

(deftest workflow
  (u/for-all-impls
   #(testing "README example"
      (is (= (-> (u/parse "http://google.com/search?q=url#fragment")
                 (.withHost "brightcove.com")
                 (.addQueryParam "foo", "bar")
                 str)
             "http://brightcove.com/search?q=url&foo=bar#fragment")))))
