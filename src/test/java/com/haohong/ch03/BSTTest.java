package com.haohong.ch03;

import com.haohong.ch03.inter.SortedST;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

/**
 * Created by haohong on 17/12/2017.
 */
public class BSTTest extends TestCase {
    public void testST()
    {
        SortedST<String, String> st = new BST<String, String>();

//        for (String key : st.keys()) {
//            StdOut.println(key);
//            assert false;
//        }

        assert st.size() == 0;
        assert st.isEmpty();

        assert !st.contains("foo");

        st.put("foo", "bar");
        assert st.contains("foo");
        assert st.size() == 1;
        assert !st.isEmpty();

        st.put("foo2", "bar2");
        assert st.contains("foo2");
        assert st.size() == 2;

        assert st.get("foo").equals("bar");
        assert st.get("foo2").equals("bar2");

        st.put("foo", "barbar");
        assert st.size() == 2;
        assert st.get("foo").equals("barbar");

        int count = 0;
//        for (String key : st.keys()) {
//            StdOut.println(key);
//        }
    }

    public void testMaxMinFloorCeiling()
    {
        SortedST<Integer, String> st = new BST<Integer, String>();

        st.put(3, "haha");
        st.put(5, "haha");
        st.put(1, "haha");
        st.put(9, "haha");
        st.put(6, "haha");
        st.put(8, "haha");
        st.put(7, "haha");
        st.put(2, "haha");

        assert st.max() == 9;
        assert st.min() == 1;

        assert st.floor(5) == 5;
        assert st.floor(4) == 3;
        assert st.floor(10) == 9;
        assert st.floor(0) == null;

        assert st.ceiling(5) == 5;
        assert st.ceiling(4) == 5;
        assert st.ceiling(10) == null;
        assert st.ceiling(0) == 1;

    }
}
