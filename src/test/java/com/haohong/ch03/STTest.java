package com.haohong.ch03;

import com.haohong.ch03.inter.ST;
import edu.princeton.cs.algs4.StdOut;
import junit.framework.TestCase;

/**
 * Created by haohong on 13/12/2017.
 */
public class STTest extends TestCase {
    public void testST() {
        ST<String, String> st = new SequentialSearchST<String, String>();

        for (String key : st.keys()) {
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
            switch (count) {
                case 0:
                    assert key.equals("foo2");
                    break;
                case 1:
                    assert key.equals("foo");
                    break;
                default:
                    throw new RuntimeException("ERROR");
            }
            count++;
        }
    }

    public void testST2() {
        ST<String, String> st = new SequentialSearchST<String, String>();
        st.put("foo", "bar");
        st.put("foo2", "bar2");
        st.put("foo3", "bar3");
        st.put("foo4", "bar4");

        st.delete("foo4");

        for (String key : st.keys()) {
            StdOut.println(key);
        }
    }
}
