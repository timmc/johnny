(ns org.timmc.johnny.string-encoder
  (:require [clojure.test :refer :all])
  (:import (org.timmc.johnny.internal
            Constants StringEncoder ByCharPercentEncoder
            Ascii7Oracle ImmutableBitSet BitSetUtils)))

(deftest char-encoding
  (let [pass-none (ByCharPercentEncoder. Ascii7Oracle/EMPTY)
        pass-print (ByCharPercentEncoder.
                    (Ascii7Oracle. Constants/ASCII_PRINTABLE))]
    (testing "empty string"
      (is (= (.encode pass-none "") "")))
    (testing "ascii"
      (is (= (.encode pass-none "\u0000abc\r\n%") "%00%61%62%63%0D%0A%25"))
      (is (= (.encode pass-print "\u0000abc\r\n%") "%00abc%0D%0A%")))
    (testing "unicode"
      (is (= (.encode pass-none "℠") "%E2%84%A0")))
    (testing "combines surrogates to UTF-8"
      (is (= (.encode pass-none "\ud800\udc00") "%F0%90%80%80"))))
  (testing "alt char encodings"
    ;; TODO: Test UTF-16 (and get rid of BOM?)
    (let [utf-32 (java.nio.charset.Charset/forName "UTF-32")]
      (is (= (.encode (ByCharPercentEncoder. Ascii7Oracle/EMPTY utf-32)
                      "\ud800\udc00")
             "%00%01%00%00")))))

;;;; Oracles

(defn in-out-char
  "Test the charset for containing/not containing members of the two
sets of Characters."
  [cs in out]
  (doseq [c in]
    (is (.containsChar cs c)))
  (doseq [c out]
    (is (not (.containsChar cs c)))))

(defn in-out-cp
  "Test the charset for containing/not containing members of the two
sets of integer code points."
  [cs in out]
  (doseq [i in]
    (is (.containsCodePoint cs i)))
  (doseq [i out]
    (is (not (.containsCodePoint cs i)))))

(deftest construction
  (testing "empty"
    (doseq [e [Ascii7Oracle/EMPTY
               (Ascii7Oracle. ImmutableBitSet/EMPTY)]]
      ;; Test alpha, control, non-ASCII, and surrogate half
      (in-out-char e #{} #{\a \space \u0000 \u096e (char 0xd800)})
      ;; Also test non-BMP character
      (in-out-cp e #{} #{0x61 0x20 0 0x96e 0xd800 0x10000})))
  (let [base-bits (BitSetUtils/fromChars "hello")
        oracle (Ascii7Oracle. base-bits)]
    (testing "inclusion"
      (in-out-char oracle "ehlo" " i\u096e\u0000")
      (in-out-cp oracle (map int "ehlo") [0x20 0x69 0x096e 0x0000]))
    (testing "constructor"
      (let [uni-bits (.set base-bits 128)]
        (is (thrown? IllegalArgumentException
                     (Ascii7Oracle. uni-bits))))
      (let [astral-bits (.set base-bits 10000)]
        (is (thrown? IllegalArgumentException
                     (Ascii7Oracle. astral-bits)))))))
