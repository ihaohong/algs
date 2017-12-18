package com.haohong.ch03;

import com.haohong.ch03.inter.SortedST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by haohong on 17/12/2017.
 */
public class BSTTest {
    public void testST()
    {
        SortedST<String, String> st = new BST<String, String>();

        for (String key : st.keys()) {
//            StdOut.println(key);
            assert false;
        }

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
        for (String key : st.keys()) {
            StdOut.println(key);
        }
    }
}
