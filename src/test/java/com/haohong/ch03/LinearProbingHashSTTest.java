package com.haohong.ch03;

import com.haohong.ch03.inter.ST;
import edu.princeton.cs.algs4.In;
import junit.framework.TestCase;

public class LinearProbingHashSTTest extends TestCase {
    public void testSTPutGet() {
        ST<String, String> st = new LinearProbingHashST<String, String>();

        assert st.get("a") == null;

        st.put("a", "aa");
        assert st.get("a").equals("aa");

    }

    public void testFrequencyCounter() {
        String[] words = new In("src/test/resource/tale.txt").readAllStrings();

        int minlen = 8;
        ST<String, Integer> st = new LinearProbingHashST<String, Integer>();

        int count = 0;
        for (String word : words) {

            if (word.equals("business")) {
                count++;
            }

            if (word.length() < minlen) {
                continue;
            }

            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }

        assert st.get("business") == 122;

//        String max = "";
//        st.put(max, 0);
//        for (String word : st.keys()) {
//            if (st.get(word) > st.get(max)) {
//                max = word;
//            }
//        }
//
//        assert max.equals("business");
    }

    public void testSizeIsEmpty() {
        ST<String, String> st = new LinearProbingHashST<String, String>();

        assert st.size() == 0;
        assert st.isEmpty();

        st.put("a", "aa");

        assert st.size() == 1;
        assert !st.isEmpty();
    }

    public void testDelete() {
        ST<String, String> st = new LinearProbingHashST<String, String>();

        st.put("a", "aa");

        assert st.size() == 1;
        assert !st.isEmpty();

        st.put("b", "bb");

        assert st.size() == 2;


        st.put("c", "cc");

        assert st.size() == 3;

        st.delete("b");

        assert st.size() == 2;
        assert st.get("b") == null;
    }

}
